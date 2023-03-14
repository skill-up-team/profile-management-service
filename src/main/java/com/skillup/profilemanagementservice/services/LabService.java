package com.skillup.profilemanagementservice.services;

import com.skillup.profilemanagementservice.dto.LaboratoryDTO;
import com.skillup.profilemanagementservice.dto.LaboratoryServiceDTO;
import com.skillup.profilemanagementservice.mappers.LabMapper;
import com.skillup.profilemanagementservice.models.Laboratory;
import com.skillup.profilemanagementservice.models.LaboratoryService;
import com.skillup.profilemanagementservice.repositories.LabServiceRepository;
import com.skillup.profilemanagementservice.repositories.LaboratoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LabService {

    private final LaboratoryRepository laboratoryRepository;
    private final LabServiceRepository labServiceRepository;

    public List<LaboratoryDTO> getAllLabs() {
        List<Laboratory> laboratories = laboratoryRepository.findAll();
        return laboratories.stream()
                .map(laboratory -> LabMapper.INSTANCE.toLabDTO(laboratory))
                .collect(Collectors.toList());
    }

    public LaboratoryDTO getLabById(int id) {
        Laboratory laboratory = laboratoryRepository.findById(id).orElse(new Laboratory());
        return LabMapper.INSTANCE.toLabDTO(laboratory);
    }

    public List<LaboratoryServiceDTO> getLabServicesByLab(int id) {
        Optional<Laboratory> laboratory = laboratoryRepository.findById(id);
        Optional<List<LaboratoryService>> laboratoryServices = labServiceRepository.findAllByLaboratory(laboratory);
        return laboratoryServices.map(optionalList ->
                optionalList.stream()
                        .map(laboratoryService -> LabMapper.INSTANCE.toLabServiceDTO(laboratoryService))
                        .collect(Collectors.toList())).orElse(new ArrayList<>());
    }

    public void addLabService(LaboratoryServiceDTO laboratoryService) {
        labServiceRepository.save(LabMapper.INSTANCE.toLabService(laboratoryService));
    }

    public void deleteLabService(int id) {
        labServiceRepository.deleteById(id);
    }

}
