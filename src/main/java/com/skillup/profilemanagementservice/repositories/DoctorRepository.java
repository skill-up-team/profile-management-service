package com.skillup.profilemanagementservice.repositories;

import com.skillup.profilemanagementservice.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
