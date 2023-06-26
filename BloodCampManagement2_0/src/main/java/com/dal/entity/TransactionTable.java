package com.dal.entity;

import org.hibernate.annotations.CascadeType;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TransactionTable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long trans_id;
	
	@ManyToOne()
	@JoinColumn(name="donor_id",referencedColumnName="donor_id")
	private Donor donor;
	
	@Column(name="bld_units_ml")
	private float blood_units;
	
	@Column
	private String bld_collect_date;
	
	@Column
	private String bld_expire_date; 
	
	@ManyToOne()
	@JoinColumn(name="camp_code",referencedColumnName="camp_code")
	private GenerateCamp generateCamp;
	
}
