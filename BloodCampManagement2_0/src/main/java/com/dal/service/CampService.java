package com.dal.service;

import java.util.List;
import java.util.Optional;

import com.dal.entity.GenerateCamp;
import com.dal.entity.TransactionTable;
import com.dal.exception.CampAlreadyExistException;
import com.dal.exception.CampNotFoundException;
import com.dal.exception.DetailsNotFoundException;
import com.dal.exception.UserDoesNotExistException;

public interface CampService {
	public GenerateCamp addGenerateCamp(GenerateCamp generateCamp) throws CampAlreadyExistException;
	public List<GenerateCamp> listAllGenerateCamp();
	public void deleteById(Long camp_code) throws CampNotFoundException;
	public GenerateCamp updateCampTable(GenerateCamp generateCamp) throws UserDoesNotExistException;
	public Optional<GenerateCamp> searchByCampName(String camp_name) throws DetailsNotFoundException;
}
