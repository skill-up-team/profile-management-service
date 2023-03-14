package com.skillup.profilemanagementservice.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    @ManyToOne
    private Specialization specialization;

}
