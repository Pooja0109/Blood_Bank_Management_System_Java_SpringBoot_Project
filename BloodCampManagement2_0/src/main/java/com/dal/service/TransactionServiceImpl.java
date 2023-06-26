package com.dal.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dal.entity.AuthUsers;
import com.dal.entity.TransactionTable;
import com.dal.exception.CampAlreadyExistException;
import com.dal.exception.TransactionNotFoundException;
import com.dal.exception.UserDoesNotExistException;
import com.dal.repository.AuthUserRepository;
import com.dal.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private AuthUserRepository authUserRepository;
	
	@Override
	public void deleteById(Long trans_id) throws TransactionNotFoundException
	{
		if(transactionRepository.findById(trans_id).isEmpty())
		{
			throw new TransactionNotFoundException();
		}
		else
		transactionRepository.deleteById(trans_id);
	}

	@Override
	public TransactionTable addTransaction(TransactionTable transactionTable) {
		return transactionRepository.save(transactionTable);
	}

	@Override
	public List<TransactionTable> listAllTransactions() {
		return (List<TransactionTable>) transactionRepository.findAll();
	}

	@Override
	public AuthUsers addAuthUsers(AuthUsers authUsers) {
		return authUserRepository.save(authUsers);
	}

	@Override
	public List<TransactionTable> sortTransById() {
		List<TransactionTable> trans = (List<TransactionTable>) transactionRepository.findAll();
	    trans.sort(Comparator.comparingLong(TransactionTable::getTrans_id));
	    return trans;
	}
	

	@Override
	public List<TransactionTable> sortBloodUnits() {
		List<TransactionTable> trans = (List<TransactionTable>) transactionRepository.findAll();
	    trans.sort(Comparator.comparingDouble(TransactionTable::getBlood_units));
	    return trans;
	}
	
	//Search method
	@Override
	public Optional<TransactionTable> searchByTransId(Long trans_id) throws UserDoesNotExistException {
		// TODO Auto-generated method stub
		if(transactionRepository.findById(trans_id).isPresent())
		{
			System.out.println("User not existed");
			throw new UserDoesNotExistException();
		}
		else{
		return transactionRepository.findById(trans_id);
		}
	}
	
	//update method
		@Override
		public TransactionTable updatetransactionTable(TransactionTable traTable) throws UserDoesNotExistException {
		    if (traTable.getTrans_id() != 0 && transactionRepository.existsById(traTable.getTrans_id())) {
		        return transactionRepository.save(traTable);
		    } else {
		        // Handle the case when the donor does not exist
		    	 throw new UserDoesNotExistException();
		    }
		}

		

}
