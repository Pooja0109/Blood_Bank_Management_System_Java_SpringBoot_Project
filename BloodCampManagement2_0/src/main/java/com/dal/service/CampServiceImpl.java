package com.dal.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dal.entity.Donor;
import com.dal.entity.GenerateCamp;
import com.dal.entity.TransactionTable;
import com.dal.exception.CampAlreadyExistException;
import com.dal.exception.CampNotFoundException;
import com.dal.exception.DetailsNotFoundException;
import com.dal.exception.UserAlreadyExistException;
import com.dal.exception.UserDoesNotExistException;
import com.dal.repository.DonorRepository;
import com.dal.repository.GenerateCampRepository;
import com.dal.repository.TransactionRepository;


@Service
public class CampServiceImpl implements CampService {
	
	@Autowired
	private GenerateCampRepository generateCampRepository;
	
	@Override
	public GenerateCamp addGenerateCamp(GenerateCamp generateCamp) throws CampAlreadyExistException {
		if(generateCampRepository.findById(generateCamp.getCamp_code()).isPresent())
		{
			throw new CampAlreadyExistException();
		}
		else
		return generateCampRepository.save(generateCamp);
	}
	
	@Override
	public List<GenerateCamp>listAllGenerateCamp() {
		
		return (List<GenerateCamp>)generateCampRepository.findAll();
	}
	
	@Override
	public void deleteById(Long camp_code) throws CampNotFoundException
	{
		if(generateCampRepository.findById(camp_code).isEmpty())
		{
			throw new CampNotFoundException();
		}
		else
		generateCampRepository.deleteById(camp_code);
	}

	
	@Override
	public GenerateCamp updateCampTable(GenerateCamp generateCamp) throws UserDoesNotExistException {
		if (generateCamp.getCamp_code() != 0 && generateCampRepository.existsById(generateCamp.getCamp_code())) {
	        return generateCampRepository.save(generateCamp);
	    } else {
	        // Handle the case when the donor does not exist
	    	 throw new UserDoesNotExistException();
	    }
	}

	@Override
	public Optional<GenerateCamp> searchByCampName(String camp_name) throws DetailsNotFoundException {
		return generateCampRepository.findByCampName(camp_name);
	}
	

}
