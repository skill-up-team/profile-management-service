package com.skillup.profilemanagementservice.dto;

import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Laboratory is mandatory")
    private LaboratoryDTO laboratoryDTO;
    @NotNull(message = "Service is mandatory")
    private ServiceDTO serviceDTO;
}
