package com.skillup.profilemanagementservice.repositories;

import com.skillup.profilemanagementservice.models.Laboratory;
import com.skillup.profilemanagementservice.models.LaboratoryService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LabServiceRepository extends JpaRepository<LaboratoryService, Integer> {

    Optional<List<LaboratoryService>> findAllByLaboratory(Optional<Laboratory> laboratory);
}
