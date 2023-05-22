package com.rogue.pfm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rogue.pfm.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findByName(String name);

}
