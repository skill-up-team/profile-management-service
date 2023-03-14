package com.skillup.profilemanagementservice.repositories;

import com.skillup.profilemanagementservice.models.Doctor;
import com.skillup.profilemanagementservice.models.DoctorHospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorHospitalRepository extends JpaRepository<DoctorHospital, Integer> {

    Optional<List<DoctorHospital>> findAllByDoctor(Optional<Doctor> doctor);
}
