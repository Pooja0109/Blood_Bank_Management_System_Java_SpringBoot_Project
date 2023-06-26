package com.dal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dal.entity.Donor;
import com.dal.entity.GenerateCamp;

public interface DonorRepository extends CrudRepository<Donor,Long> {

	Optional<Donor> findByAadhar(Long aadhar);

	List<Donor> findByBloodGrp(String bld_grp);
	
}
