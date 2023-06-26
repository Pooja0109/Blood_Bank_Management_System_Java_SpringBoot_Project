package com.dal.service;

import java.util.List;
import java.util.Optional;

import com.dal.entity.AuthUsers;
import com.dal.entity.TransactionTable;
import com.dal.exception.TransactionNotFoundException;
import com.dal.exception.UserDoesNotExistException;

public interface TransactionService {
	
	public TransactionTable addTransaction(TransactionTable transactionTable);
	public List<TransactionTable> listAllTransactions();
	public void deleteById(Long trans_id) throws TransactionNotFoundException;
	public AuthUsers addAuthUsers(AuthUsers authUsers);
	 //sort
		public List<TransactionTable> sortTransById();
		public List<TransactionTable> sortBloodUnits();
	//searchById
		public Optional<TransactionTable> searchByTransId(Long trans_id) throws UserDoesNotExistException;
	//Update
		public TransactionTable updatetransactionTable(TransactionTable transactionTable) throws UserDoesNotExistException;
		
		
		
	
}
