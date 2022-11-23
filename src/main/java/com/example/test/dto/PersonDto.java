package com.example.test.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonDto {
	
	private Long id;

	@NotNull
	@Size(max = 100)
	private String name;

	@NotNull
	@Size(max = 150)
	private String email;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
