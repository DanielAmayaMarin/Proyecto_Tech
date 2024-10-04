package com.sistema.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Permite solicitudes desde cualquier origen
        config.addAllowedOrigin("*");

        // Permite solicitudes desde un solo lugar
        //config.addAllowedOrigin("https://tu-frontend.com");

        // Permite los métodos HTTP especificados
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("OPTIONS");

        // Permite todos los encabezados
        config.addAllowedHeader("*");

        // Permite que las credenciales sean incluidas en la solicitud
        config.setAllowCredentials(true);

        // Aplica esta configuración a todas las rutas
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
