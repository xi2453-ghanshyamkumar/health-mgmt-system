package com.example.test.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.test.dto.DoctorsDto;

public interface DoctorsService {

	List<DoctorsDto> getAllDoctors(Pageable pageable);

	DoctorsDto createDoctor(DoctorsDto doctorDto);

	DoctorsDto updateDoctor(Long doctorId, DoctorsDto doctorDtoRequest);

	String deleteDoctor(Long doctorId);

}
