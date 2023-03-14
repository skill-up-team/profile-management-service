package com.skillup.profilemanagementservice.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;


@Entity
@Table(name = "doctor_hospitals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class DoctorHospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Hospital hospital;
    private int dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private double channelFee;
    private boolean availability;

}
