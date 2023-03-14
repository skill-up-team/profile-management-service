package com.skillup.profilemanagementservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "laboratories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Laboratory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String regNum;
    private String address;

}
