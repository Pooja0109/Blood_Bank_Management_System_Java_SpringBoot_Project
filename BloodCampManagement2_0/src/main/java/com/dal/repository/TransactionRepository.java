package com.dal.repository;

import org.springframework.data.repository.CrudRepository;

import com.dal.entity.TransactionTable;

public interface TransactionRepository extends CrudRepository<TransactionTable,Long> {

}
