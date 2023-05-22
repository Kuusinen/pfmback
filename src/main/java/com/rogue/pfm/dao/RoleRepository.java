package com.rogue.pfm.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rogue.pfm.model.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

	Optional<Role> findByName(String name);
}
