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

import com.example.test.dto.PatientsDto;
import com.example.test.exception.ResourceNotFoundException;
import com.example.test.model.Patients;
import com.example.test.repository.DoctorsRepository;
import com.example.test.repository.PatientsRepository;
import com.example.test.service.PatientsService;

@Service("patientsService")
public class PatientsServiceImpl implements PatientsService {

	@Autowired
	private PatientsRepository patientsRepository;

	@Autowired
	private DoctorsRepository doctorsRepository;

	@Override
	public List<PatientsDto> getAllPatientsByDoctorId(Long doctorId, Pageable pageable) {

		List<PatientsDto> patientsDtosRes = new ArrayList<>();
		Page<Patients> patientsPage = patientsRepository.findByDoctorId(doctorId, pageable);
		List<Patients> listPatients = patientsPage.getContent();

		if (!CollectionUtils.isEmpty(listPatients)) {
			listPatients.stream().forEach(patient -> {
				PatientsDto patientDto = new PatientsDto();
				BeanUtils.copyProperties(patient, patientDto);
				patientsDtosRes.add(patientDto);
			});

		}

		return patientsDtosRes;
	}

	@Override
	public PatientsDto createPatient(Long doctorId, PatientsDto patientDto) {
		return doctorsRepository.findById(doctorId).map(doctor -> {
			Patients patient = new Patients();
			BeanUtils.copyProperties(patientDto, patient);
			patient.setDoctor(doctor);
			Patients patientSave = patientsRepository.save(patient);
			if (Objects.nonNull(patientSave)) {
				BeanUtils.copyProperties(patientSave, patientDto);
			}
			return patientDto;
		}).orElseThrow(() -> new ResourceNotFoundException("DoctorId " + doctorId + " not found"));
	}

	@Override
	public PatientsDto updatePatient(Long doctorId, Long patientId, PatientsDto patientDtoRequest) {

		if (!doctorsRepository.existsById(doctorId)) {
			throw new ResourceNotFoundException("DoctorId " + doctorId + " not found");
		}

		return patientsRepository.findById(patientId).map(patient -> {
			patient.setName(patientDtoRequest.getName());
			patient.setEmail(patientDtoRequest.getEmail());
			patient.setContactNo(patientDtoRequest.getContactNo());
			Patients patientsUpate = patientsRepository.save(patient);
			if (Objects.nonNull(patientsUpate)) {
				BeanUtils.copyProperties(patientsUpate, patientDtoRequest);
			}

			return patientDtoRequest;
		}).orElseThrow(() -> new ResourceNotFoundException("PatientId " + patientId + "not found"));
	}

	@Override
	public String deletePatient(Long doctorId, Long patientId) {
		return patientsRepository.findByIdAndDoctorId(patientId, doctorId).map(patient -> {
			patientsRepository.delete(patient);
			return "Patient successfully deleted for given doctor Id and Patient Id!";
		}).orElseThrow(() -> new ResourceNotFoundException(
				"Patient not found with id " + patientId + " and doctorId " + doctorId));

	}

}
