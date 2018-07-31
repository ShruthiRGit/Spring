package com.reserve.service;

import com.reserve.bean.Guest;
import com.reserve.store.GuestException;

public interface LoginService {

	public int addGuest(Guest guest) throws GuestException;
	
	public boolean validateGuest(String emailId, String password) throws GuestException;
}
