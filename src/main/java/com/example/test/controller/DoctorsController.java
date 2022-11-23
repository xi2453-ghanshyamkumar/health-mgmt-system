package com.example.test.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.dto.DoctorsDto;
import com.example.test.service.DoctorsService;

@RestController
public class DoctorsController {

	@Autowired
	private DoctorsService doctorsService;

	@GetMapping("/doctors")
	public List<DoctorsDto> getAllDoctors(Pageable pageable) {
		return doctorsService.getAllDoctors(pageable);
	}

	@PostMapping("/doctors")
	public DoctorsDto createDoctor(@Valid @RequestBody DoctorsDto doctorDto) {
		return doctorsService.createDoctor(doctorDto);
	}

	@PutMapping("/doctors/{doctorId}")
	public DoctorsDto updateDoctor(@PathVariable Long doctorId, @Valid @RequestBody DoctorsDto doctorDtoRequest) {
		return doctorsService.updateDoctor(doctorId, doctorDtoRequest);
	}

	@DeleteMapping("/doctors/{doctorId}")
	public ResponseEntity<String> deleteDoctor(@PathVariable Long doctorId) {
		return ResponseEntity.ok(doctorsService.deleteDoctor(doctorId));
	}

}
