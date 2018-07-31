package com.reserve.config;

import org.springframework.security.authentication.AbstractAuthenticationToken;

import com.reserve.bean.Guest;


/**
 * This class is responsible for holding the raw token value and - if authenticated - the {@link User}.
 */
public class AuthenticationToken extends AbstractAuthenticationToken {
	private final String token;
	private final Guest guest;

	public AuthenticationToken(String token) {
		super(null);

		this.token = token;
		this.guest = null;
		setAuthenticated(false);
	}

	public AuthenticationToken(String token, Guest guest) {
		//note that the constructor needs a collection of GrantedAuthority
		//but our User have a collection of our UserRole's
		super(guest.getRoles());

		this.token = token;
		this.guest = guest;
		setAuthenticated(true);
	}

	@Override
	public Object getCredentials() {
		return getToken();
	}

	@Override
	public Object getPrincipal() {
		return getGuest();
	}

	public String getToken() {
		return token;
	}

	public Guest getGuest() {
		return guest;
	}
}