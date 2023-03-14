package com.skillup.profilemanagementservice.services;

import com.skillup.profilemanagementservice.dto.LaboratoryDTO;
import com.skillup.profilemanagementservice.models.Laboratory;
import com.skillup.profilemanagementservice.repositories.LabServiceRepository;
import com.skillup.profilemanagementservice.repositories.LaboratoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LabServiceTest {

    @Mock
    private LaboratoryRepository laboratoryRepository;
    @Mock
    private LabServiceRepository labServiceRepository;
    @InjectMocks
    private LabService labService;

    @Test
    void testGetAllLabs() {
        List<Laboratory> laboratories = Arrays.asList(
                new Laboratory(1, "Test lab1", "123", "Test1"),
                new Laboratory(2, "Test lab2", "234", "Test2"),
                new Laboratory(3, "Test lab3", "345", "Test3")
        );

        when(laboratoryRepository.findAll()).thenReturn(laboratories);

        List<LaboratoryDTO> laboratoryDTOS = labService.getAllLabs();

        assertEquals(3, laboratoryDTOS.size());
        verify(laboratoryRepository, times(1)).findAll();
    }

    @Test
    void testGetLabById() {
        Laboratory laboratory = new Laboratory(1, "Test lab1", "123", "Test1");

        when(laboratoryRepository.findById(1)).thenReturn(Optional.of(laboratory));

        LaboratoryDTO laboratoryDTO = labService.getLabById(1);

        assertEquals("Test lab1", laboratoryDTO.getName());
        assertEquals("123", laboratoryDTO.getRegNum());
        assertEquals("Test1", laboratoryDTO.getAddress());
    }

    @Test
    void testGetLabServicesByLab() {}

    @Test
    void testAddLabService() {}

    @Test
    void testDeleteLabService() {}
}
