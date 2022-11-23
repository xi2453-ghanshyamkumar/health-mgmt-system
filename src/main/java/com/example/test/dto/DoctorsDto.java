package com.example.test.dto;

import javax.validation.constraints.Size;

public class DoctorsDto extends PersonDto {

	@Size(max = 50)
	private String degree;

	@Size(max = 100)
	private String specialization;

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

}
