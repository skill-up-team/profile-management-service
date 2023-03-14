package com.skillup.profilemanagementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class DoctorDTO {

    private int id;
    private String firstName;
    private String lastName;
    private SpecializationDTO specializationDTO;
}
