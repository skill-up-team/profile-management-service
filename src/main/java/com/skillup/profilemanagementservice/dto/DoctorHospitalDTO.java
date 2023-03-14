package com.skillup.profilemanagementservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class DoctorHospitalDTO {

    private int id;
    @NotNull(message = "Doctor is mandatory")
    private DoctorDTO doctorDTO;
    @NotNull(message = "Hospital is mandatory")
    private HospitalDTO hospitalDTO;
    @NotNull(message = "Day of week is mandatory")
    private int dayOfWeek;
    @NotNull(message = "Start time is mandatory")
    private LocalTime startTime;
    @NotNull(message = "End time is mandatory")
    private LocalTime endTime;
    private double channelFee;
    private boolean availability;
}
