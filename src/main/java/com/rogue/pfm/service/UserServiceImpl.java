package com.rogue.pfm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rogue.pfm.dao.RoleRepository;
import com.rogue.pfm.dao.UserRepository;
import com.rogue.pfm.model.Role;
import com.rogue.pfm.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	BCryptPasswordEncoder cryptPasswordEncoder;

	@Override
	public User saveUser(final User user) {

		updateUserWithGoodRole(user);

		user.setPassword(cryptPasswordEncoder.encode(user.getPassword()));

		return userRepository.save(user);
	}

	private void updateUserWithGoodRole(final User user) {
		final Optional<Role> roleFind = roleRepository.findByName(user.getRole().getName());

		if (roleFind.isPresent()) {
			user.setRole(roleFind.get());
		} else {
			roleRepository.save(user.getRole());
		}
	}

	@Override
	public User findUserByName(final String name) {
		return userRepository.findByName(name);
	}

	@Override
	public Role saveRole(final Role role) {
		return roleRepository.save(role);
	}

}
