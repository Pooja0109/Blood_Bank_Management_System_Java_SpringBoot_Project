package com.dal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dal.entity.AuthUsers;
import com.dal.entity.Donor;
import com.dal.entity.GenerateCamp;
import com.dal.entity.TransactionTable;
import com.dal.exception.CampAlreadyExistException;
import com.dal.exception.CampNotFoundException;
import com.dal.exception.DetailsNotFoundException;
import com.dal.exception.TransactionNotFoundException;
import com.dal.exception.UserAlreadyExistException;
import com.dal.exception.UserDoesNotExistException;
import com.dal.repository.AuthUserRepository;
import com.dal.repository.DonorRepository;
import com.dal.repository.GenerateCampRepository;
import com.dal.service.CampService;
import com.dal.service.DonorService;
import com.dal.service.TransactionService;



@RestController
public class GenerateCampRestController {
	
	
	@Autowired
	AuthUserRepository authUserRepository;
	
	@Autowired
	GenerateCampRepository generateCampRepository;
	
	@Autowired
	DonorRepository donorRepository;
	
	@Autowired
	DonorService donorService;
	
	@Autowired
	CampService campService;
	
	@Autowired
	TransactionService transactionService;
	
	@GetMapping("/welcome")
	public static String welcome() {
		return "Welcome To BBMS Blood Bank";
	}
	
	@PostMapping("/addUser")
	public AuthUsers addAuthUsers(@RequestBody AuthUsers authUsers) {
		// TODO Auto-generated method stub
		return transactionService.addAuthUsers(authUsers);
	}
	
	@PostMapping("/addDonor")
	public Donor addDonor(@RequestBody Donor donor) throws UserAlreadyExistException {
		return donorService.addDonor(donor);
	}

	@GetMapping("/listDonor")
	public List<Donor> listAllDonor() {
		return donorService.listAllDonor();
	}
	
	@DeleteMapping("/deleteDonor/{donor_id}")
	public void deleteDonor(@PathVariable("donor_id") Long donor_id) throws UserDoesNotExistException {
		donorService.deleteById(donor_id);
	}
	
	@PostMapping("/addCamp")
	public GenerateCamp addGenerateCamp(@RequestBody GenerateCamp generateCamp) throws CampAlreadyExistException {
		// TODO Auto-generated method stub
		return campService.addGenerateCamp(generateCamp);
	}
	
	@GetMapping("/listCampDetails")
	public List<GenerateCamp> listAllGenerateCamp() {
		return campService.listAllGenerateCamp();
	}
	
	@DeleteMapping("/deleteCamp/{camp_code}")
	public void deleteGenerateCamp(@PathVariable("camp_code") Long camp_code) throws CampNotFoundException {
		campService.deleteById(camp_code);
	}
	
	@PostMapping("/addTransaction")
	public TransactionTable addtransaction(@RequestBody TransactionTable transactionTable) {
		// TODO Auto-generated method stub
		return transactionService.addTransaction(transactionTable);
	}
	
	@GetMapping("/listTransaction")
	public List<TransactionTable> listAllTransactions() {
		return transactionService.listAllTransactions();
	}
	
	@DeleteMapping("/deleteTransaction/{trans_id}")
	public void deleteTransactionTable(@PathVariable("trans_id") Long trans_id) throws TransactionNotFoundException {
		transactionService.deleteById(trans_id);
	}
	
	@GetMapping("/login")
	public ResponseEntity<AuthUsers> loginrest(@RequestParam(value = "username", required = false) String username,@RequestParam(value = "password", required = false) String password) 
	{
		System.out.println("*******This is a login rest controller ***********");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		AuthUsers authUsers = authUserRepository.findByUsername(auth.getName());
		System.out.println("After Login__________________"+ 
		"send back to Angular or postman as response__________________" + authUsers);
		return ResponseEntity.ok(authUsers);
	}
	
	//Shahsi
	
	//sortmethod
    @GetMapping("/sortTransById")
    public List<TransactionTable> sortTransById() {
        return transactionService.sortTransById();
    }
    
    @GetMapping("/sortBloodUnits")
    public List<TransactionTable> sortBloodUnits() {
        return transactionService.sortBloodUnits();
    }
    
    //searchMethod
    @GetMapping("/searchTransId/{trans_id}")
    public Optional<TransactionTable> searchByTransId(@PathVariable("trans_id") Long trans_id) throws UserDoesNotExistException
    {
    	return transactionService.searchByTransId(trans_id);
    }
    
  //searchMethod
    @GetMapping("/searchDonorId/{donor_id}")
    public Optional<Donor> searchByDonorId(@PathVariable("donor_id") Long donor_id) throws UserDoesNotExistException
    {
    	return donorService.searchByDonorId(donor_id);
    }
    
    @GetMapping("/searchDonorAadhar/{aadhar}")
    public Optional<Donor> searchByDonorAadhar(@PathVariable("aadhar") Long aadhar) throws UserDoesNotExistException
    {
    	return donorService.searchByDonorAadhar(aadhar);
    }
    
    @GetMapping("/searchCampName/{camp_name}")
    public Optional<GenerateCamp> searchByCampName(@PathVariable("camp_name") String camp_name) throws DetailsNotFoundException
    {
    	return campService.searchByCampName(camp_name);
    }
    
    @GetMapping("/searchByBloodGroup/{bld_grp}")
    public List<Donor> searchByBloodGrp(@PathVariable("bld_grp") String bld_grp) throws DetailsNotFoundException
    {
    	return donorService.searchByBloodGrp(bld_grp);
    }
        
    @PutMapping("/updateTransaction")
    public TransactionTable updateTransaction(@RequestBody TransactionTable tranTable) throws UserDoesNotExistException {
        return transactionService.updatetransactionTable(tranTable);
    }
    
    @PutMapping("/updateDonor")
    public Donor updateDonor(@RequestBody Donor donor) throws UserDoesNotExistException {
        return donorService.updateDonorTable(donor);
    }
    
    @PutMapping("/updateCamp")
    public GenerateCamp updateCamp(@RequestBody GenerateCamp generateCamp) throws UserDoesNotExistException {
        return campService.updateCampTable(generateCamp);
    }
    
//    @DeleteMapping("/deleteByAadhar/{aadhar}")
//    public void deleteByAadhar(@PathVariable("aadhar") Long aadhar)
//    {
//    	donorService.deleteByAadhars(aadhar);
//    }

}
