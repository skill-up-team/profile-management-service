package com.skillup.profilemanagementservice.services;

import com.skillup.profilemanagementservice.dto.DoctorDTO;
import com.skillup.profilemanagementservice.dto.DoctorHospitalDTO;
import com.skillup.profilemanagementservice.mappers.DoctorMapper;
import com.skillup.profilemanagementservice.models.Doctor;
import com.skillup.profilemanagementservice.models.DoctorHospital;
import com.skillup.profilemanagementservice.repositories.DoctorHospitalRepository;
import com.skillup.profilemanagementservice.repositories.DoctorRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorHospitalRepository doctorHospitalRepository;

    public List<DoctorDTO> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map(doctor -> DoctorMapper.INSTANCE.toDoctorDTO(doctor)).collect(Collectors.toList());
    }

    public DoctorDTO getDoctorById(int id) {
        Doctor doctor = doctorRepository.findById(id).orElse(new Doctor());
        return DoctorMapper.INSTANCE.toDoctorDTO(doctor);
    }

    public List<DoctorHospitalDTO> getAllSessions(int doctorId) {
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        Optional<List<DoctorHospital>> sessionsOptional = doctorHospitalRepository.findAllByDoctor(doctor);
        return sessionsOptional.map(sessions ->
                sessions.stream()
                        .map(session ->
                                DoctorMapper.INSTANCE.toDoctorHospitalDTO(session))
                        .collect(Collectors.toList())).orElse(new ArrayList<>());
    }

    public void createSession(DoctorHospitalDTO session) {
        doctorHospitalRepository.save(DoctorMapper.INSTANCE.toDoctorHospital(session));
    }

    public void updateSession(@NonNull Integer id, DoctorHospitalDTO session) {
        session.setId(id);
        doctorHospitalRepository.save(DoctorMapper.INSTANCE.toDoctorHospital(session));
    }
}
