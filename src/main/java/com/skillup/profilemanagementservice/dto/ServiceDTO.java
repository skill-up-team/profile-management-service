package com.skillup.profilemanagementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ServiceDTO {

    private int id;
    private String name;
    private double serviceFee;
}
