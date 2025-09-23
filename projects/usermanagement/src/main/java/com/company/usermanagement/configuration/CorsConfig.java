package com.company.usermanagement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOriginPattern("*");
        config.addAllowedOrigin("http://localhost:4200");
        config.addAllowedOrigin("http://localhost:8100");
        config.addAllowedOrigin("http://192.168.1.100:8100");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("PATCH");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedHeader("*");
        config.setAllowCredentials(true);
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//
//        // Permetti tutte le origini
//        config.addAllowedOriginPattern("*");
//
//        // Permetti tutti i metodi HTTP
//        config.addAllowedMethod("*");
//
//        // Permetti tutti gli header
//        config.addAllowedHeader("*");
//
//        // Abilita credenziali (cookie, Authorization header)
//        config.setAllowCredentials(true);
//
//        // Applica la configurazione a tutti i path
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }
}