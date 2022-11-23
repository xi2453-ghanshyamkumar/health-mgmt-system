package com.example.test.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PatientsDto extends PersonDto {

	@NotNull
	@Size(max = 15)
	private String contactNo;

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

}
