package com.sistema.api.service;

import com.sistema.api.dto.UsuarioDTO;
import com.sistema.api.model.Usuario;
import com.sistema.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario registrarUsuario(Usuario usuario) {
        Usuario consulta = usuarioRepository.findByEmail(usuario.getEmail());
        if (consulta != null) {
            throw new UsernameNotFoundException("Usuario ya se encuentra en la base de datos.");
        }
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setRol("Usuario");
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public List<UsuarioDTO> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private UsuarioDTO convertToDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getCedula(),
                usuario.getNombre(),
                usuario.getApellidos(),
                usuario.getTelefono(),
                usuario.getEmail(),
                usuario.getRol(),
                usuario.getRutaImagenPerfil()
        );
    }

    public Usuario actualizarUsuario(String cedula, Usuario usuarioActualizado) {
        return usuarioRepository.findById(cedula)
                .map(usuario -> {
                    usuario.setNombre(usuarioActualizado.getNombre());
                    usuario.setApellidos(usuarioActualizado.getApellidos());
                    usuario.setTelefono(usuarioActualizado.getTelefono());
                    usuario.setEmail(usuarioActualizado.getEmail());
                    return usuarioRepository.save(usuario);
                })
                .orElse(null);
    }

    public boolean eliminarUsuario(String cedula) {
        return usuarioRepository.findById(cedula)
                .map(usuario -> {
                    usuarioRepository.delete(usuario);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con email: " + email);
        }
        return new User(usuario.getEmail(), usuario.getPassword(), new ArrayList<>());
    }

    public String guardarImagenUsuario(String cedula, MultipartFile imagen) throws IOException {
        Usuario usuario = usuarioRepository.findById(cedula).orElse(null);
        if (usuario == null) {
            return null;
        }

        String carpetaImagenes = "/Users/chm3572/Documents/imagenes_perfil/";
        Files.createDirectories(Paths.get(carpetaImagenes));

        String nombreArchivo = cedula + "_" + System.currentTimeMillis() + "_" + imagen.getOriginalFilename();
        Path rutaCompleta = Paths.get(carpetaImagenes + nombreArchivo);

        Files.write(rutaCompleta, imagen.getBytes());

        usuario.setRutaImagenPerfil(rutaCompleta.toString());
        usuarioRepository.save(usuario);

        return rutaCompleta.toString();
    }

}
