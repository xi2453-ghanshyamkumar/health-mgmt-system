package com.example.test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.test.dto.DoctorsDto;
import com.example.test.exception.ResourceNotFoundException;
import com.example.test.model.Doctors;
import com.example.test.repository.DoctorsRepository;
import com.example.test.service.DoctorsService;

@Service("doctorsService")
public class DoctorsServiceImpl implements DoctorsService {

	@Autowired
	private DoctorsRepository doctorsRepository;

	@Override
	public List<DoctorsDto> getAllDoctors(Pageable pageable) {

		List<DoctorsDto> doctorsDtosRes = new ArrayList<>();
		Page<Doctors> doctorsPage = doctorsRepository.findAll(pageable);
		List<Doctors> listDoctors = doctorsPage.getContent();

		if (!CollectionUtils.isEmpty(listDoctors)) {
			listDoctors.stream().forEach(doctor -> {
				DoctorsDto doctorsDto = new DoctorsDto();
				BeanUtils.copyProperties(doctor, doctorsDto);
				doctorsDtosRes.add(doctorsDto);
			});
		}

		return doctorsDtosRes;
	}

	@Override
	public DoctorsDto createDoctor(DoctorsDto doctorDto) {
		Doctors doctor = new Doctors();
		BeanUtils.copyProperties(doctorDto, doctor);

		Doctors doctorSaveRes = doctorsRepository.save(doctor);

		DoctorsDto doctorsDtoRes = new DoctorsDto();

		if (Objects.nonNull(doctorSaveRes)) {
			BeanUtils.copyProperties(doctorSaveRes, doctorsDtoRes);
		}
		return doctorsDtoRes;
	}

	@Override
	public DoctorsDto updateDoctor(Long doctorId, DoctorsDto doctorDtoRequest) {
		return doctorsRepository.findById(doctorId).map(doctor -> {
			doctor.setName(doctorDtoRequest.getName());
			doctor.setEmail(doctorDtoRequest.getEmail());
			doctor.setDegree(doctorDtoRequest.getDegree());
			doctor.setSpecialization(doctorDtoRequest.getSpecialization());
			DoctorsDto doctorsDtoUpdateRes = new DoctorsDto();
			Doctors doctorUpdateRes = doctorsRepository.save(doctor);

			if (Objects.nonNull(doctorUpdateRes)) {
				BeanUtils.copyProperties(doctorUpdateRes, doctorsDtoUpdateRes);
			}
			return doctorsDtoUpdateRes;
		}).orElseThrow(() -> new ResourceNotFoundException("DoctorId " + doctorId + " not found"));
	}

	@Override
	public String deleteDoctor(Long doctorId) {
		return doctorsRepository.findById(doctorId).map(doctor -> {
			doctorsRepository.delete(doctor);
			return "Doctor Deleted successfully for given doctor Id";
		}).orElseThrow(() -> new ResourceNotFoundException("DoctorId " + doctorId + " not found"));
	}

}
