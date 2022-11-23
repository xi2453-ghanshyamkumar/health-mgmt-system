package com.example.test.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.test.model.Patients;

@Repository
public interface PatientsRepository extends JpaRepository<Patients, Long> {

	Page<Patients> findByDoctorId(Long doctorId, Pageable pageable);

	Optional<Patients> findByIdAndDoctorId(Long id, Long doctorId);

}
