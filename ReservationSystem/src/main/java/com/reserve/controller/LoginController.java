package com.reserve.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.reserve.bean.Guest;
import com.reserve.config.AuthenticationToken;
import com.reserve.dto.AuthDTO;
import com.reserve.dto.ErrorResponse;
import com.reserve.dto.LoginResponse;
import com.reserve.store.GuestStore;
import com.reserve.store.TokenStore;

/**
 * This controller contains the endpoints for handling user tokens.
 */
@RestController
public class LoginController {

	@Autowired
	GuestStore guestStore;

	@Autowired
	TokenStore tokenStore;

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object login(@RequestBody AuthDTO auth) {
		Guest guest = guestStore.get(auth.getEmail());
		if (guest != null && guest.getPassword().equals(auth.getPassword())) {
			final String token = UUID.randomUUID().toString();
			tokenStore.put(token, auth.getEmail());

			return new LoginResponse(token);
		}

		return new ResponseEntity(new ErrorResponse("Username or password are incorrect!"), HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(path = "/me/logout", method = RequestMethod.POST)
	public void logout(AuthenticationToken authToken) {
		tokenStore.remove(authToken.getToken());
	}
}
