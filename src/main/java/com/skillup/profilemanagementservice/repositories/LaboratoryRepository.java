package com.skillup.profilemanagementservice.repositories;

import com.skillup.profilemanagementservice.models.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory, Integer> {
}
