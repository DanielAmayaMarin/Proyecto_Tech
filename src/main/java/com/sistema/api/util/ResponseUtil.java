package com.sistema.api.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> ResponseEntity<Map<String, Object>> buildResponse(T data, String mensaje, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put("codigo", status.value());
        response.put("data", data != null ? data : Collections.emptyList());
        response.put("mensaje", mensaje);
        return ResponseEntity.status(status).body(response);
    }

    public static ResponseEntity<Map<String, Object>> buildSuccessResponse(Object data, String mensaje) {
        return buildResponse(data, mensaje, HttpStatus.OK);
    }

    public static ResponseEntity<Map<String, Object>> buildErrorResponse(String mensaje, HttpStatus status) {
        return buildResponse(null, mensaje, status);
    }

    public static void sendErrorResponse(HttpServletResponse response, HttpStatus status, String message) throws IOException {
        response.setStatus(status.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        Map<String, Object> body = new HashMap<>();
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("message", message);
        objectMapper.writeValue(response.getOutputStream(), body);
    }

    public static ResponseEntity<Map<String, Object>> buildAuthResponse(
            int codigo,
            String jwt,
            Date fechaExp,
            String mensaje,
            String email,
            HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put("codigo", codigo);
        response.put("jwt", jwt);
        response.put("exp", fechaExp);
        response.put("mensaje", mensaje);
        response.put("email", email);
        return ResponseEntity.status(status).body(response);
    }
}
