package com.dal.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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

public class GenerateCamp {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
//	    @SequenceGenerator(name = "camp_generator", sequenceName = "camp_sequence", allocationSize = 1)
	    private Long camp_code;

	    @Column(nullable = false,name="Camp_name")
	    private String campName;

	    @Column(nullable = false)
	    private String doctor_name;

	    @Column(name="Conduct_date")
	    private String camp_conduct;

		public Long getCamp_code() {
			return camp_code;
		}

		public void setCamp_code(Long camp_code) {
			this.camp_code = camp_code;
		}

		public String getcampName() {
			return campName;
		}

		public void setcampName(String campName) {
			this.campName = campName;
		}

		public String getDoctor_name() {
			return doctor_name;
		}
		public void setDoctor_name(String doctor_name) {
			this.doctor_name = doctor_name;
		}

		public String getcamp_conduct() {
			return camp_conduct;
		}

		public void setcamp_conduct(String camp_conduct) {
			this.camp_conduct = camp_conduct;
		}
	    
//		
//		@OneToMany(mappedBy="generateCamp",cascade = CascadeType.ALL,orphanRemoval = true)
//		private List<TransactionTable> transactionTable; 
//	
}
