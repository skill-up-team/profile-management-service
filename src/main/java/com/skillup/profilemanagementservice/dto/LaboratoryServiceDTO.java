package com.skillup.profilemanagementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class LaboratoryServiceDTO {

    private int id;
    private LaboratoryDTO laboratoryDTO;
    private ServiceDTO serviceDTO;
}
