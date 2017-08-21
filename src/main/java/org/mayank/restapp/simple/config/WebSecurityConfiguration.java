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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	/**
	 * Bean declaration of custom filter to intercept url's and inspect for JWT
	 * token
	 * 
	 * @return Custom JwtAuthenticationFilter
	 * @throws Exception
	 */
	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilterBean() throws Exception {
		JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter("/auth/**");
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#authenticationManagerBean()
	 */
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	/**
	 * Custom jwtAuthenticationProvider to be used to validate the request
	 */
	@Autowired
	JwtAuthenticationProvider jwtAuthenticationProvider;

	@Autowired
	RestAppAuthenticationEntryPoint restAppAuthenticationEntryPoint;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.
	 * config.annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.authenticationProvider(this.jwtAuthenticationProvider);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.
	 * config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().exceptionHandling().authenticationEntryPoint(restAppAuthenticationEntryPoint)
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.authorizeRequests().antMatchers("/auth/**").hasAuthority("Role_User");

		// Adding the CustomFilter in security
		httpSecurity.addFilterBefore(jwtAuthenticationFilterBean(), UsernamePasswordAuthenticationFilter.class);

		// disable page caching
		httpSecurity.headers().cacheControl();
	}
}