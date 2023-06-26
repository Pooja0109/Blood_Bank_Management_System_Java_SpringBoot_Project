package com.dal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
@ToString
public class AuthUsers {
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


//	public int getStaff_code() {
//		return staff_code;
//	}
//
//	public void setStaff_code(int staff_code) {
//		this.staff_code = staff_code;
//	}
//
//
//	@Id
//	private int staff_code;
//	
	@Id
	@Column
	private String username;
	
	@Column
	private String password;

}
