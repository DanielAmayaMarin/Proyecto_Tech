package com.sistema.api.controller;


import com.sistema.api.dto.UsuarioDTO;
import com.sistema.api.model.Usuario;
import com.sistema.api.service.UsuarioService;
import com.sistema.api.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/{email}")
    public ResponseEntity<?> buscarPorEmail(@PathVariable String email) {
        Usuario usuario = usuarioService.buscarPorEmail(email);
        if (usuario != null) {
            return ResponseUtil.buildSuccessResponse(usuario, "Usuario encontrado exitosamente");
        } else {
            return ResponseUtil.buildErrorResponse("El usuario con el email " + email + " no fue encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> listarUsuarios() {
        List<UsuarioDTO> usuarios = usuarioService.listarTodos();
        return ResponseUtil.buildSuccessResponse(usuarios, "Usuarios encontrados exitosamente");
    }

    @PutMapping("/{cedula}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable String cedula, @RequestBody Usuario usuario) {
        Usuario usuarioActualizado = usuarioService.actualizarUsuario(cedula, usuario);
        if (usuarioActualizado != null) {
            return ResponseEntity.ok(usuarioActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable String cedula) {
        boolean eliminado = usuarioService.eliminarUsuario(cedula);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{cedula}/imagen")
    public ResponseEntity<?> cargarImagenUsuario(@PathVariable String cedula, @RequestParam("imagen") MultipartFile imagen) {
        try {
            String rutaImagen = usuarioService.guardarImagenUsuario(cedula, imagen);
            if (rutaImagen != null) {
                return ResponseUtil.buildSuccessResponse(rutaImagen, "Imagen cargada exitosamente");
            } else {
                return ResponseUtil.buildErrorResponse("No se pudo cargar la imagen para el usuario con cédula " + cedula, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return ResponseUtil.buildErrorResponse("Error al procesar la imagen: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
