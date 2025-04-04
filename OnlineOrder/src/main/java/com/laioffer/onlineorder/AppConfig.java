package com.laioffer.onlineorder;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import javax.sql.DataSource;

/**
 * @author luluxue
 * @date 2024-10-12 10:13 AM
 */
@Configuration // let SpringBoot know we need to call these two functions
	          // if we change to @service, it does not work as @Configuration
		      // 内部预留了它们，可以使之去调用
public class AppConfig {
	
	@Bean // October 14
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.authorizeHttpRequests(auth ->
						auth
								.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
								.requestMatchers(HttpMethod.GET, "/", "/index.html", "/*.json", "/*.png", "/static/**").permitAll() // 打包前端的资源包，都有权限
								.requestMatchers(HttpMethod.POST, "/login", "/logout", "/signup").permitAll()
								.requestMatchers(HttpMethod.GET, "/restaurants/**", "/restaurant/**").permitAll()
								.anyRequest().authenticated() //
				)
				.exceptionHandling()
				.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)) // 验证错误处理
				.and()
				.formLogin()
				.successHandler((req, res, auth) -> res.setStatus(HttpStatus.OK.value()))
				.failureHandler(new SimpleUrlAuthenticationFailureHandler())
				.and()
				.logout()
				.logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK));
		return http.build();
	}
	
	
	@Bean // ?? let SpringBoot know we need to call these two functions
	UserDetailsManager users(DataSource dataSource) {
		// implement these coding in the SQL body
		// UserDetailManager is an interface
		JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
		userDetailsManager.setCreateUserSql("INSERT INTO customers (email, password, enabled) VALUES (?,?,?)");
		userDetailsManager.setCreateAuthoritySql("INSERT INTO authorities (email, authority) values (?,?)");
		userDetailsManager.setUsersByUsernameQuery("SELECT email, password, enabled FROM customers WHERE email = ?");
		userDetailsManager.setAuthoritiesByUsernameQuery("SELECT email, authorities FROM authorities WHERE email = ?");
		
		return userDetailsManager;
	}
	
	
	@Bean // ?? 咖啡豆
		  // encode the password
	PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	
}

