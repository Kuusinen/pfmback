package com.rogue.pfm.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
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

		final JwtAuthentificationFilter customFilter = new JwtAuthentificationFilter(authenticationManager());
		customFilter.setFilterProcessesUrl("/api/login");

		return http.csrf().disable().cors(Customizer.withDefaults()).authorizeHttpRequests(authz -> {
			authz.requestMatchers(HttpMethod.GET, "/image/**").permitAll();
			authz.requestMatchers(HttpMethod.GET, "/api/carousel").permitAll();
			authz.requestMatchers(HttpMethod.GET, "/api/category").permitAll();
			authz.requestMatchers(HttpMethod.GET, "/api/product/**").permitAll();
			authz.requestMatchers(HttpMethod.GET, "/api/category/**").permitAll();
			authz.requestMatchers(HttpMethod.POST, "/api/email").permitAll();
			authz.requestMatchers(HttpMethod.POST, "/api/carousel").hasAuthority("ADMIN");
			authz.requestMatchers(HttpMethod.DELETE, "/api/carousel/remove").hasAuthority("ADMIN");
			authz.requestMatchers(HttpMethod.POST, "/api/category").hasAuthority("ADMIN");
			authz.requestMatchers(HttpMethod.POST, "/api/product").hasAuthority("ADMIN");
			authz.requestMatchers(HttpMethod.DELETE, "/api/category/remove").hasAuthority("ADMIN");
			authz.requestMatchers(HttpMethod.POST, "/image/upload").hasAuthority("ADMIN");
			authz.requestMatchers(HttpMethod.POST, "/api/login").permitAll();
			authz.anyRequest().denyAll();
		}).addFilter(customFilter)
				.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().build();
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
