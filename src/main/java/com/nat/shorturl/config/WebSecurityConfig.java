package com.nat.shorturl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return
            http
                .authorizeHttpRequests((requests) -> requests
                    .requestMatchers("/actuator/**").hasRole("ADMIN")
                    .requestMatchers("/api/v1/urls").hasRole("USER")
                    .requestMatchers("/api/v1/urls/*").permitAll()
                    .anyRequest().denyAll()
                )
                .cors(withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(withDefaults()))
                .build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        final JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(source -> mapAuthorities(source.getClaims()));
        return converter;
    }


    private List<GrantedAuthority> mapAuthorities(final Map<String, Object> attributes) {
        @SuppressWarnings("unchecked") final Map<String, Object> realmAccess =
            ((Map<String, Object>) attributes.getOrDefault("realm_access", Collections.emptyMap()));
        @SuppressWarnings("unchecked") final Collection<String> roles =
            ((Collection<String>) realmAccess.getOrDefault("roles", Collections.emptyList()));
        return roles.stream()
            .map(role -> ((GrantedAuthority) new SimpleGrantedAuthority(role)))
            .toList();
    }
}