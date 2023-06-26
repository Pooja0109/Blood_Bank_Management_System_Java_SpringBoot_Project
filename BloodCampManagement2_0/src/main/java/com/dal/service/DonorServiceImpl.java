package com.dal.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.dal.entity.Donor;
import com.dal.entity.TransactionTable;
import com.dal.exception.DetailsNotFoundException;
import com.dal.exception.UserAlreadyExistException;
import com.dal.exception.UserDoesNotExistException;
import com.dal.repository.DonorRepository;

@Service
public  class DonorServiceImpl implements DonorService {

	@Autowired
	private DonorRepository donorRepository;

	@Override
	public List<Donor> listAllDonor() {
		return (List<Donor>) donorRepository.findAll();
	}

	@Override
	public Donor addDonor(Donor donor) throws UserAlreadyExistException {
		if (donorRepository.findById(donor.getDonor_id()).isPresent()) {
			throw new UserAlreadyExistException();
		} else
			return donorRepository.save(donor);
	}

	@Override
	public void deleteById(Long donor_id) throws UserDoesNotExistException {
		if (donorRepository.findById(donor_id).isEmpty()) {
			throw new UserDoesNotExistException();
		} else
			donorRepository.deleteById(donor_id);
	}

	// update method
	@Override
	public Donor updateDonorTable(Donor donor) throws UserDoesNotExistException {
		if (donor.getDonor_id() != 0 && donorRepository.existsById(donor.getDonor_id())) {
			return donorRepository.save(donor);
		} else {
			// Handle the case when the donor does not exist
			throw new UserDoesNotExistException();
		}
	}

	// Search method
	@Override
	public Optional<Donor> searchByDonorId(Long donor_id) throws UserDoesNotExistException {
		// TODO Auto-generated method stub
		return donorRepository.findById(donor_id);
	}
	
	@Override
	public List<Donor> searchByBloodGrp(String bld_grp) throws DetailsNotFoundException {
		// TODO Auto-generated method stub
		return (List<Donor>)donorRepository.findByBloodGrp(bld_grp);
	}

	@Override
	public Optional<Donor> searchByDonorAadhar(Long aadhar) throws UserDoesNotExistException {
		return donorRepository.findByAadhar(aadhar);
	}

	
	
	
		
		

	
}
