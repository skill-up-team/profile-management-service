package com.skillup.profilemanagementservice.services;

import com.skillup.profilemanagementservice.dto.DoctorDTO;
import com.skillup.profilemanagementservice.dto.DoctorHospitalDTO;
import com.skillup.profilemanagementservice.dto.HospitalDTO;
import com.skillup.profilemanagementservice.models.Doctor;
import com.skillup.profilemanagementservice.models.DoctorHospital;
import com.skillup.profilemanagementservice.models.Hospital;
import com.skillup.profilemanagementservice.repositories.DoctorHospitalRepository;
import com.skillup.profilemanagementservice.repositories.DoctorRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;
    @Mock
    private DoctorHospitalRepository doctorHospitalRepository;
    @InjectMocks
    private DoctorService doctorService;

    @Test
    void testGetAllDoctors() {
        List<Doctor> doctorList = new ArrayList<>();
        Doctor doctor1 = Doctor.builder().id(1).firstName("John").lastName("Test1").build();
        Doctor doctor2 = Doctor.builder().id(2).firstName("Steve").lastName("Test2").build();
        Doctor doctor3 = Doctor.builder().id(3).firstName("Anne").lastName("Test3").build();

        doctorList.add(doctor1);
        doctorList.add(doctor2);
        doctorList.add(doctor3);

        when(doctorRepository.findAll()).thenReturn(doctorList);

        List<DoctorDTO> doctorDTOList = doctorService.getAllDoctors();

        assertEquals(3, doctorDTOList.size());
        verify(doctorRepository, times(1)).findAll();
    }

    @Test
    void testGetDoctorById() {
        Doctor doctor = Doctor.builder()
                .id(1)
                .firstName("John")
                .lastName("Test")
                .build();
        when(doctorRepository.findById(1)).thenReturn(Optional.of(doctor));

        DoctorDTO doctorDTO = doctorService.getDoctorById(1);

        assertEquals("John", doctorDTO.getFirstName());
        assertEquals("Test", doctorDTO.getLastName());

    }

    @Test
    void testGetAllSessions() {
        List<DoctorHospital> sessions = new ArrayList<>();
        Doctor doctor = Doctor.builder()
                .id(1)
                .firstName("John")
                .lastName("Test")
                .build();
        Hospital hospital = Hospital.builder()
                .id(1)
                .name("Test Hospital")
                .build();
        DoctorHospital session1 = DoctorHospital.builder()
                .id(1)
                .doctor(doctor)
                .hospital(hospital)
                .dayOfWeek(1)
                .startTime(LocalTime.of(15, 0, 0))
                .endTime(LocalTime.of(17, 0, 0))
                .channelFee(2000.0)
                .availability(true)
                .build();
        DoctorHospital session2 = DoctorHospital.builder()
                .id(1)
                .doctor(doctor)
                .hospital(hospital)
                .dayOfWeek(2)
                .startTime(LocalTime.of(18, 0, 0))
                .endTime(LocalTime.of(20, 0, 0))
                .channelFee(2000.0)
                .availability(true)
                .build();
        DoctorHospital session3 = DoctorHospital.builder()
                .id(1)
                .doctor(doctor)
                .hospital(hospital)
                .dayOfWeek(3)
                .startTime(LocalTime.of(6, 0, 0))
                .endTime(LocalTime.of(8, 0, 0))
                .channelFee(2000.0)
                .availability(true)
                .build();

        sessions.add(session1);
        sessions.add(session2);
        sessions.add(session3);

        when(doctorRepository.findById(1)).thenReturn(Optional.of(doctor));
        when(doctorHospitalRepository.findAllByDoctor(Optional.of(doctor))).thenReturn(Optional.of(sessions));

        List<DoctorHospitalDTO> doctorHospitalDTOS = doctorService.getAllSessions(1);
        assertEquals(3, doctorHospitalDTOS.size());
        assertEquals(1, doctorHospitalDTOS.get(0).getDoctorDTO().getId());
        assertEquals(1, doctorHospitalDTOS.get(1).getDoctorDTO().getId());
        assertEquals(1, doctorHospitalDTOS.get(2).getDoctorDTO().getId());

    }

    @Test
    void testCreateSession() {
        DoctorDTO doctorDTO = DoctorDTO.builder()
                .id(1)
                .firstName("John")
                .lastName("Test")
                .build();
        HospitalDTO hospitalDTO = HospitalDTO.builder()
                .id(1)
                .name("Test Hospital")
                .build();
        DoctorHospitalDTO doctorHospitalDTO = DoctorHospitalDTO.builder()
                .doctorDTO(doctorDTO)
                .hospitalDTO(hospitalDTO)
                .dayOfWeek(1)
                .startTime(LocalTime.of(15, 0, 0))
                .endTime(LocalTime.of(17, 0, 0))
                .channelFee(2000.0)
                .availability(true)
                .build();

        doctorService.createSession(doctorHospitalDTO);

        //TODO

    }

    @Test
    void testUpdateSession() {
        //TODO
    }
}
