package com.api.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	// Client ID & Client Secret
	static final String CLIENT_ID = "techmaster";
	static final String CLIENT_SECRET = "techmaster_secret";
	static final String GRANT_TYPE_PASSWORD = "password";
	static final String REFRESH_TOKEN = "refresh_token";
	static final String SCOPE_READ = "read";
	static final String SCOPE_WRITE = "write";
	static final String TRUST = "trust";
	static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1 * 60 * 60;
	static final int REFRESH_TOKEN_VALIDITY_SECONDS = 6 * 60 * 60;

	@Autowired
	private JwtAccessTokenConverter jwtAccessTokenConverter;

	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {

		configurer.inMemory().withClient(CLIENT_ID).secret(passwordEncoder.encode(CLIENT_SECRET))
				.authorizedGrantTypes(GRANT_TYPE_PASSWORD, REFRESH_TOKEN).scopes(SCOPE_READ, SCOPE_WRITE, TRUST)
				.accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS)
				.refreshTokenValiditySeconds(REFRESH_TOKEN_VALIDITY_SECONDS);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), jwtAccessTokenConverter));

		endpoints.userDetailsService(userDetailsService);
		endpoints.tokenStore(tokenStore).tokenEnhancer(tokenEnhancerChain).authenticationManager(authenticationManager);
	}

	@Bean
	public TokenEnhancer tokenEnhancer() {
		return new CustomerTokenEnhancer();
	}
}
