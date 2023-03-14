package com.skillup.profilemanagementservice.controllers;

import com.skillup.profilemanagementservice.dto.LaboratoryDTO;
import com.skillup.profilemanagementservice.dto.LaboratoryServiceDTO;
import com.skillup.profilemanagementservice.services.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lab")
public class LabController {

    @Autowired
    LabService labService;

    @GetMapping("")
    public ResponseEntity<List<LaboratoryDTO>> getAllLabs() {
        return new ResponseEntity<>(labService.getAllLabs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LaboratoryDTO> getLabById(@PathVariable int id) {
        return new ResponseEntity<>(labService.getLabById(id), HttpStatus.OK);
    }

    @GetMapping("/service/{labId}")
    public ResponseEntity<List<LaboratoryServiceDTO>> getServicesByLab(@PathVariable("labId") int id) {
        return new ResponseEntity<>(labService.getLabServicesByLab(id), HttpStatus.OK);
    }

    @PostMapping("/service")
    public ResponseEntity<HttpStatus> addLabService(@RequestBody LaboratoryServiceDTO laboratoryService) {
        labService.addLabService(laboratoryService);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/service/{id}")
    public ResponseEntity<HttpStatus> deleteLabService(@PathVariable int id) {
        labService.deleteLabService(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
