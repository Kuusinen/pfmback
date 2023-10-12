package com.rogue.pfm.service;

import com.rogue.pfm.model.Role;
import com.rogue.pfm.model.User;

public interface UserService {

	User saveUser(User user);

	User findUserByName(String name);

	Role saveRole(Role role);
}
