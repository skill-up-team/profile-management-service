package com.skillup.profilemanagementservice.controllers;

import com.skillup.profilemanagementservice.dto.DoctorDTO;
import com.skillup.profilemanagementservice.dto.DoctorHospitalDTO;
import com.skillup.profilemanagementservice.services.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping("")
    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
        return new ResponseEntity<>(doctorService.getAllDoctors(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable int id) {
        return new ResponseEntity<>(doctorService.getDoctorById(id), HttpStatus.OK);
    }

    @GetMapping("/session/{doctorId}")
    public ResponseEntity<List<DoctorHospitalDTO>> getAllSessions(@PathVariable("doctorId") int id) {
        return new ResponseEntity<>(doctorService.getAllSessions(id), HttpStatus.OK);
    }

    @PostMapping("/session")
    public ResponseEntity<HttpStatus> createSession(@Valid @RequestBody DoctorHospitalDTO session) {
        doctorService.createSession(session);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/session/{id}")
    public ResponseEntity<HttpStatus> updateSession(@PathVariable int id, @RequestBody DoctorHospitalDTO session) {
        doctorService.updateSession(id, session);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
