package com.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private ResourceServerTokenServices tokenServices;

	private static final String RESOURCE_ID = "resource_id";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID).tokenServices(tokenServices);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
//				.antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security",
//                "/swagger-ui.html", "/webjars/**", "/swagger-resources/configuration/ui",
//                "/swagger-resources/configuration/security").permitAll() //permit swagger through oAuth2
//				.antMatchers(HttpMethod.POST, "/v1/students").permitAll()
//				.antMatchers(HttpMethod.GET, "/v1/teachers").permitAll()
//				.antMatchers(HttpMethod.GET, "/v1/subjects").permitAll()
				.antMatchers("/**").permitAll();
	}

}
