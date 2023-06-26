package com.dal.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dal.entity.GenerateCamp;

public interface GenerateCampRepository extends CrudRepository<GenerateCamp, Long> {

	Optional<GenerateCamp> findByCampName(String camp_name);

}
