package com.reserve.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reserve.Dao.LoginDao;
import com.reserve.bean.Guest;
import com.reserve.store.GuestException;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;

	@Override
	public int addGuest(Guest guest) throws GuestException{
		return loginDao.addGuest(guest);
	}

	@Override
	public boolean validateGuest(String emailId, String password) throws GuestException{
		return loginDao.validateGuest(emailId, password);
	}

}
