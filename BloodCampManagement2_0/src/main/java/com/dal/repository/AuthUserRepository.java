package com.dal.repository;

import org.springframework.data.repository.CrudRepository;

import com.dal.entity.AuthUsers;

public interface AuthUserRepository extends CrudRepository<AuthUsers,Long> {

	AuthUsers findByUsername(String username);
	
}
