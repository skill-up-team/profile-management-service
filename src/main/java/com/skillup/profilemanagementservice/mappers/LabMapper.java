package com.skillup.profilemanagementservice.mappers;

import com.skillup.profilemanagementservice.dto.LaboratoryDTO;
import com.skillup.profilemanagementservice.dto.LaboratoryServiceDTO;
import com.skillup.profilemanagementservice.dto.ServiceDTO;
import com.skillup.profilemanagementservice.models.Laboratory;
import com.skillup.profilemanagementservice.models.LaboratoryService;
import com.skillup.profilemanagementservice.models.Service;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LabMapper {

    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    LaboratoryDTO toLabDTO(Laboratory laboratory);

    Laboratory toLab(LaboratoryDTO laboratoryDTO);

    ServiceDTO toServiceDTO(Service service);

    Service toService(ServiceDTO serviceDTO);

    @Mapping(source = "laboratoryService.laboratory", target = "laboratoryDTO")
    @Mapping(source = "laboratoryService.service", target = "serviceDTO")
    LaboratoryServiceDTO toLabServiceDTO(LaboratoryService laboratoryService);

    @Mapping(source = "laboratoryServiceDTO.laboratoryDTO", target = "laboratory")
    @Mapping(source = "laboratoryServiceDTO.serviceDTO", target = "service")
    LaboratoryService toLabService(LaboratoryServiceDTO laboratoryServiceDTO);
}
