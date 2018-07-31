package com.reserve.bean;

import org.springframework.security.core.GrantedAuthority;

public enum GuestRole implements GrantedAuthority {
	USER,
	ADMIN;

	@Override
	public String getAuthority() {
		return name();
	}
	

}
