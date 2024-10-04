package com.sistema.api.security;

import com.sistema.api.util.ResponseUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
       // response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No autorizado");
        ResponseUtil.sendErrorResponse(response, HttpStatus.UNAUTHORIZED, "Token inválido o expirado");
    }
}