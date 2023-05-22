package com.rogue.pfm.security;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SecurityConfig {

	@Autowired
	UserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(
				authz -> {
					authz.requestMatchers("/api/**").hasAuthority("ADMIN");
					authz.requestMatchers("/login").permitAll();
					authz.anyRequest().denyAll();
				}).csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilter(new JwtAuthentificationFilter(authenticationManager()));
		http.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManager() {

		final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(getBCryptPasswordEncoder());

		final List<AuthenticationProvider> providers = List.of(authProvider);

		return new ProviderManager(providers);
	}

	@Bean
	protected BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}