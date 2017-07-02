package org.mayank.restapp.simple.config;

import org.mayank.restapp.simple.security.JwtAuthenticationFilter;
import org.mayank.restapp.simple.security.JwtAuthenticationProvider;
import org.mayank.restapp.simple.security.RestAppAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	JwtAuthenticationProvider jwtAuthenticationProvider;

	@Autowired
	RestAppAuthenticationEntryPoint restAppAuthenticationEntryPoint;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilterBean() throws Exception {
		JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter("/api/**");
		jwtAuthenticationFilter.setAuthenticationManager(authenticationManagerBean());
		return jwtAuthenticationFilter;
	}

	/**
	 * We do this to ensure our Filter is only loaded once into Application
	 * Context
	 *
	 */
	@Bean(name = "authenticationFilterRegistration")
	public FilterRegistrationBean myAuthenticationFilterRegistration(JwtAuthenticationFilter filter) {
		final FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(filter);
		filterRegistrationBean.setEnabled(false);
		return filterRegistrationBean;
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.authenticationProvider(this.jwtAuthenticationProvider);
	}

	/*
	 * @Override public void configure(WebSecurity web){
	 * web.ignoring().antMatchers("/login"); }
	 */

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().exceptionHandling().authenticationEntryPoint(restAppAuthenticationEntryPoint)
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/signup").permitAll()
				.antMatchers("/employee/**").permitAll().antMatchers("/test").permitAll();

		// Adding the CustomFilter in security
		httpSecurity.addFilterBefore(jwtAuthenticationFilterBean(), UsernamePasswordAuthenticationFilter.class);

		// disable page caching
		httpSecurity.headers().cacheControl();
	}
}