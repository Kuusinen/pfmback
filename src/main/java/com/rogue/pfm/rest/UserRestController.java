package com.rogue.pfm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rogue.pfm.model.Role;
import com.rogue.pfm.model.User;
import com.rogue.pfm.service.UserService;

@RestController
@CrossOrigin({ "petit-fil-modele.fr.nf", "www.petit-fil-modele.fr.nf" })
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserService service;

	@PostMapping()
	public void createUser(@RequestBody final User user) {
		service.saveUser(user);
	}

	@PostMapping(path = "/role")
	public void createRole(@RequestBody final Role role) {
		service.saveRole(role);
	}
}
