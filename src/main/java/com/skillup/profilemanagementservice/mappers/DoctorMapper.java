package com.skillup.profilemanagementservice.mappers;

import com.skillup.profilemanagementservice.dto.DoctorDTO;
import com.skillup.profilemanagementservice.dto.DoctorHospitalDTO;
import com.skillup.profilemanagementservice.dto.HospitalDTO;
import com.skillup.profilemanagementservice.dto.SpecializationDTO;
import com.skillup.profilemanagementservice.models.Doctor;
import com.skillup.profilemanagementservice.models.DoctorHospital;
import com.skillup.profilemanagementservice.models.Hospital;
import com.skillup.profilemanagementservice.models.Specialization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DoctorMapper {

    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    SpecializationDTO toSpecializationDTO(Specialization specialization);

    @Mapping(source = "doctor.specialization", target = "specializationDTO")
    DoctorDTO toDoctorDTO(Doctor doctor);

    @Mapping(source = "doctorDTO.specializationDTO", target = "specialization")
    Doctor toDoctor(DoctorDTO doctorDTO);

    HospitalDTO toHospitalDTO(Hospital hospital);

    Hospital toHospital(HospitalDTO hospitalDTO);

    @Mapping(source = "doctorHospital.doctor", target = "doctorDTO")
    @Mapping(source = "doctorHospital.hospital", target = "hospitalDTO")
    DoctorHospitalDTO toDoctorHospitalDTO(DoctorHospital doctorHospital);

    @Mapping(source = "doctorHospitalDTO.doctorDTO", target = "doctor")
    @Mapping(source = "doctorHospitalDTO.hospitalDTO", target = "hospital")
    DoctorHospital toDoctorHospital(DoctorHospitalDTO doctorHospitalDTO);


}
