package com.dal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;

import com.dal.entity.Donor;
import com.dal.entity.GenerateCamp;
import com.dal.entity.TransactionTable;
import com.dal.exception.DetailsNotFoundException;
import com.dal.exception.UserAlreadyExistException;
import com.dal.exception.UserDoesNotExistException;


public interface DonorService {
	
	public Donor addDonor(Donor donor) throws UserAlreadyExistException;
	public List<Donor> listAllDonor();
	public void deleteById(Long donor_id) throws UserDoesNotExistException;
	public Donor updateDonorTable(Donor donor) throws UserDoesNotExistException;
	public Optional<Donor> searchByDonorId(Long donor_id) throws UserDoesNotExistException;
	public Optional<Donor> searchByDonorAadhar(Long aadhar) throws UserDoesNotExistException;
	public List<Donor> searchByBloodGrp(String bld_grp) throws DetailsNotFoundException;//Custome delete
}
