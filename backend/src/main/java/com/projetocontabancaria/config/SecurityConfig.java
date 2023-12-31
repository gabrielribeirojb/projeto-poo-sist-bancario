package com.projetocontabancaria.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private static final String[] PUBLIC_MATCHERS = { "/**" };

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.headers((headers) -> headers.frameOptions((frameOptions) -> frameOptions.disable()));
		http.csrf((csrf) -> csrf.disable());
		http.cors((cors) -> cors.disable());
		http.authorizeRequests().requestMatchers(PUBLIC_MATCHERS).permitAll();
		http.sessionManagement((sessionManagement) -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
