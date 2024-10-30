package com.sistema.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.sistema.api.model.AuthenticationRequest;
import com.sistema.api.model.AuthenticationResponse;
import com.sistema.api.model.Usuario;
import com.sistema.api.security.JwtUtil;
import com.sistema.api.service.UsuarioService;
import com.sistema.api.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Autenticación", description = "API para autenticación y registro de usuarios")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    @Operation(summary = "Iniciar sesión", description = "Autentica un usuario y devuelve un token JWT")
    @ApiResponse(responseCode = "200", description = "Autenticación exitosa",
            content = @Content(schema = @Schema(implementation = AuthenticationResponse.class)))
    @ApiResponse(responseCode = "401", description = "Credenciales incorrectas")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            return ResponseUtil.buildErrorResponse("Credenciales incorrectas "+ e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        final UserDetails userDetails = usuarioService.loadUserByUsername(authenticationRequest.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails);
        final Date expirationDate = jwtUtil.extractExpiration(jwt);
        return ResponseUtil.buildAuthResponse(
                HttpStatus.OK.value(),
                jwt,
                expirationDate,
                "Inicio de sesión exitoso",
                authenticationRequest.getEmail(),
                HttpStatus.OK
        );
        //return ResponseUtil.buildSuccessResponse(jwt, "Inicio de sesión exitoso");
    }

    @PostMapping("/registro")
    @Operation(summary = "Registrar usuario", description = "Registra un nuevo usuario en el sistema")
    @ApiResponse(responseCode = "200", description = "Usuario registrado exitosamente",
            content = @Content(schema = @Schema(implementation = Usuario.class)))
    @ApiResponse(responseCode = "400", description = "Error en los datos de registro")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario) {
        System.out.println(usuario);
        try {
            Usuario usuarioRegistrado = usuarioService.registrarUsuario(usuario);
            return ResponseEntity.ok(usuarioRegistrado);
        } catch (Exception e) {
            return ResponseUtil.buildErrorResponse("Error al procesar el registro: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}