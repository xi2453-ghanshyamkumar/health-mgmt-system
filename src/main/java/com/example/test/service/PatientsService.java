package com.example.test.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.test.dto.PatientsDto;

public interface PatientsService {

	List<PatientsDto> getAllPatientsByDoctorId(Long doctorId, Pageable pageable);

	PatientsDto createPatient(Long doctorId, PatientsDto patientDto);

	PatientsDto updatePatient(Long doctorId, Long patientId, PatientsDto patientDtoRequest);

	String deletePatient(Long doctorId, Long patientId);
}
