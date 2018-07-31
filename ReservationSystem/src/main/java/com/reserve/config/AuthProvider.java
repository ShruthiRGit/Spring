package com.reserve.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.reserve.bean.Guest;
import com.reserve.store.GuestStore;
import com.reserve.store.TokenStore;


/**
 * This class is responsible for checking the token.
 */
public class AuthProvider implements AuthenticationProvider {

	@Autowired
	TokenStore tokenStore;

	@Autowired
	GuestStore guestStore;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		final AuthenticationToken tokenContainer = (AuthenticationToken) auth;
		final String token = tokenContainer.getToken();

		//do i know this token?
		if (!tokenStore.contains(token)) {
			//...if not: the token is invalid!
			throw new BadCredentialsException("Invalid token - " + token);
		}

		final String email = tokenStore.get(token);
		if (!guestStore.contains(email)) {
			//normally this shouldn't be happen
			throw new BadCredentialsException("No user found for token - " + token);
		}

		final Guest guest = guestStore.get(email);

		return new AuthenticationToken(token, guest);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		//this class is only responsible for AuthTokenContainers
		return AuthenticationToken.class.isAssignableFrom(authentication);
	}
}