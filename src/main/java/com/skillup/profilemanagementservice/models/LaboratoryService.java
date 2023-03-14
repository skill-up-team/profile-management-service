package com.skillup.profilemanagementservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lab_services")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LaboratoryService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Laboratory laboratory;
    @ManyToOne
    private Service service;

}
