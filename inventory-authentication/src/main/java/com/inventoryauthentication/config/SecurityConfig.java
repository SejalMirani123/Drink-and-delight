package com.inventoryauthentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.inventoryauthentication.security.CustomAuthenticationEntryPoint;
import com.inventoryauthentication.security.JwtAuthenticationFilter;
import com.inventoryauthentication.service.implementation.JwtUserDetailsServiceImpl;

import lombok.AllArgsConstructor;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfig {
//public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private JwtAuthenticationFilter jwtAuthenticationFilter;
	private JwtUserDetailsServiceImpl userDetailsService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors()
        .and() // Required for accessing protected routes
        .csrf()
        .disable()
        .authorizeRequests()		
        .antMatchers("/auth/**", "/swagger-ui/**", "/swagger-resources/**", "/register/**", "/v2/api-docs", "/v3/api-docs")
        .permitAll()
        .antMatchers()
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .exceptionHandling()
        .authenticationEntryPoint(authenticationEntryPoint());
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        http.headers().frameOptions().disable();
        http.authenticationProvider(daoAuthenticationProvider());
        return http.build();
    }

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

	@Bean
	 DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	/**
	 * DI for CustomAuthentiaction EntryPoint
	 */
	public AuthenticationEntryPoint authenticationEntryPoint() {
		return new CustomAuthenticationEntryPoint();
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.cors().and() // Required for accessing prpotected routes
//				.csrf().disable().authorizeRequests()
//				.antMatchers("/auth/**", "/swagger-ui/**", "/swagger-resources/**", "/register/**", "/v2/api-docs",
//						"/v3/api-docs")
//				.permitAll().antMatchers()
//				.permitAll().
//				anyRequest().
//				authenticated().and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).
//				and()
//				.exceptionHandling()
//				.authenticationEntryPoint(authenticationEntryPoint());
//		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//		http.headers().frameOptions().disable();
//	}

	/**
	 * Password Encodeer DI
	 */

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//	}

	/**
	 * In @Bean(BeanIds.AUTHENTICATION_MANAGER) NeanIds part is optional
	 */
//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}

}
