package com.quiniela.springbootserviciogatewayserver.filters.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SpringSecurityConfig {
    
    @Autowired
    private JwtAuthenticationFilter authenticationFilter;

    @Bean
    public SecurityWebFilterChain configure(ServerHttpSecurity http) {
        return http.authorizeExchange()
                .pathMatchers("/api/security/oauth/**","/api/equipos/listar/**").permitAll()
                .pathMatchers(HttpMethod.GET, "/api/grupos/listar",
                        "/api/equipos/listar",
                        "/api/usuarios/datos/listar",
                        "/api/partidos-apuestas/datos/listar").permitAll()
                .pathMatchers(HttpMethod.GET, "/api/usuarios/datos/listar/{id}").hasAnyRole("ADMIN", "USER")
                .pathMatchers("/api/equipos/**", "/api/grupos/**","/api/partidos-apuestas/datos/**", "/api/usuarios/datos/**").hasRole("ADMIN")
                .anyExchange().authenticated()
                .and().addFilterAt(authenticationFilter, SecurityWebFiltersOrder.AUTHENTICATION)
                .csrf().disable()
                .build();
    }
    
}
