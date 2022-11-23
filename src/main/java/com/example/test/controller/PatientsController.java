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

import com.example.test.dto.PatientsDto;
import com.example.test.service.PatientsService;

@RestController
public class PatientsController {

	@Autowired
	private PatientsService patientsService;

	@GetMapping("/doctors/{doctorId}/patients")
	public List<PatientsDto> getAllPatientsByDoctorId(@PathVariable(value = "doctorId") Long doctorId,
			Pageable pageable) {
		return patientsService.getAllPatientsByDoctorId(doctorId, pageable);
	}

	@PostMapping("/doctors/{doctorId}/patients")
	public PatientsDto createPatient(@PathVariable(value = "doctorId") Long doctorId,
			@Valid @RequestBody PatientsDto patientDto) {
		return patientsService.createPatient(doctorId, patientDto);
	}

	@PutMapping("/doctors/{doctorId}/patients/{patientId}")
	public PatientsDto updatePatient(@PathVariable(value = "doctorId") Long doctorId,
			@PathVariable(value = "patientId") Long patientId, @Valid @RequestBody PatientsDto patientDtoRequest) {
		return patientsService.updatePatient(doctorId, patientId, patientDtoRequest);
	}

	@DeleteMapping("/doctors/{doctorId}/patients/{patientId}")
	public ResponseEntity<String> deletePatient(@PathVariable(value = "doctorId") Long doctorId,
			@PathVariable(value = "patientId") Long patientId) {
		return ResponseEntity.ok(patientsService.deletePatient(doctorId, patientId));
	}
}
