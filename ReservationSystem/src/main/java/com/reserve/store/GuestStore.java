package com.reserve.store;

import org.springframework.stereotype.Component;

import com.reserve.bean.Guest;
import com.reserve.bean.GuestRole;

@Component
public class GuestStore extends AbstractStore<String, Guest> {
	
	public GuestStore(){
		
	}

	@Override
	protected void initilizeStore() {
		store.put("admin", new Guest("admin", "admin", GuestRole.ADMIN, GuestRole.USER));
		store.put("user", new Guest("user", "user", GuestRole.USER));
	}

	@Override
	public Guest get(String email) {
		return super.get(email);
	}

	@Override
	public boolean contains(String email) {
		return super.contains(email);
	}
}
