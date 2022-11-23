package com.example.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.model.Doctors;

@Repository
public interface DoctorsRepository extends JpaRepository<Doctors, Long> {

}
