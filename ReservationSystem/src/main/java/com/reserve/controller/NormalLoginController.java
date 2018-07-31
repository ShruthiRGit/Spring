package com.reserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reserve.bean.Guest;
import com.reserve.config.annotation.IsAdmin;
import com.reserve.service.LoginService;
import com.reserve.store.GuestException;

@RestController
@RequestMapping("/guest-login")
public class NormalLoginController {

	@Autowired
	private LoginService loginService;

	@IsAdmin
	@RequestMapping(value = "/add-guest", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Integer> addGuestDetails(@RequestBody Guest guest) throws GuestException {
		HttpHeaders headers = new HttpHeaders();
		if (guest == null) {
			return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}
		int guestId = loginService.addGuest(guest);
		headers.add("Guest Created  - ", String.valueOf(guest.getGuestId()));
		return new ResponseEntity<Integer>(guestId, headers, HttpStatus.CREATED);
	}

/*	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("errorMsg", "Your username and password are invalid.");

		if (logout != null)
			model.addAttribute("msg", "You have been logged out successfully.");

		return "login";
	}*/

	@PostMapping("/validate")
	public ResponseEntity<String> validate(@RequestBody Guest guest) throws GuestException{
		String result = "guest invalid";
		boolean v = loginService.validateGuest(guest.getEmail(), guest.getPassword());
		if (v != false) {
			result = "guest valid";
			return new ResponseEntity<String>(result, HttpStatus.FOUND);
		}
		return new ResponseEntity<String>(result, HttpStatus.NOT_FOUND);

	}

}
