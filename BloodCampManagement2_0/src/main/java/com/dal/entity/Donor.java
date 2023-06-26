package com.dal.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
@ToString
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "aadhar" }))
public class Donor {
	
	public Long getDonor_id() {
		return donor_id;
	}

	public void setDonor_id(Long donor_id) {
		this.donor_id = donor_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getbloodGrp() {
		return bloodGrp;
	}

	public void setbloodGrp(String bloodGrp) {
		this.bloodGrp = bloodGrp;
	}

	public Long getAadhar() {
		return aadhar;
	}

	public void setAadhar(Long aadhar) {
		this.aadhar = aadhar;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getMed_issues() {
		return med_issues;
	}

	public void setMed_issues(String med_issues) {
		this.med_issues = med_issues;
	}

//	public List<TransactionTable> getTransactionTable() {
//		return transactionTable;
//	}
//
//	public void setTransactionTable(List<TransactionTable> transactionTable) {
//		this.transactionTable = transactionTable;
//	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long donor_id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private int age;
	
	@Column(nullable = false)
	private String gender;
	
	@Column(nullable = false,name="bloodGrp")
	private String bloodGrp;
	
	@Column(nullable = false)
	private Long aadhar;
	
	@Column(nullable = false)
	private long phone;
	
	@Column(nullable = false)
	private String med_issues;
	
//	@OneToMany(mappedBy="donor",cascade = CascadeType.ALL,orphanRemoval = true)
//	private List<TransactionTable> transactionTable; 

}
