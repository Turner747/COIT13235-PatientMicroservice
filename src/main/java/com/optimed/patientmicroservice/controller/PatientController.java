
package com.optimed.patientmicroservice.controller;

import com.optimed.patientmicroservice.mapper.ObjectMapper;
import com.optimed.patientmicroservice.model.Patient;
import com.optimed.patientmicroservice.repository.PatientRepository;
import com.optimed.patientmicroservice.response.PatientResponse;

import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/patients")
public class PatientController {

    private PatientRepository patientRepo;
    
    @PostMapping
    public ResponseEntity<PatientResponse> savePatient(@RequestBody Patient patient) {
        Patient new_patient = patientRepo.save(patient);
    
        return ResponseEntity.status(HttpStatus.CREATED).body(ObjectMapper.map(new_patient, PatientResponse.class));
    }
    
    @GetMapping
    public ResponseEntity<Collection<PatientResponse>> getAllPatients() {
        List<Patient> patients = patientRepo.findAll();
        
        if(patients.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            List<PatientResponse> patientResponse = ObjectMapper.mapAll(patients, PatientResponse.class);
            
            return ResponseEntity.status(HttpStatus.OK).body(patientResponse);
        }
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<PatientResponse> getPatientById(@PathVariable("id") Long id) {
        Optional<Patient> optional = patientRepo.findById(id);
        
        if(optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            PatientResponse patientResponse = ObjectMapper.map(optional, PatientResponse.class);
            
            return ResponseEntity.status(HttpStatus.OK).body(patientResponse);
        }
    }
    
    @PutMapping("/id/{id}")
    public ResponseEntity<PatientResponse> updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatient) {
        Optional<Patient> optional = patientRepo.findById(id);
        
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            Patient existingPatient = optional.get();
            existingPatient = ObjectMapper.map(updatedPatient, Patient.class);
            PatientResponse patientResponse = ObjectMapper.map(patientRepo.save(existingPatient), PatientResponse.class);

            return ResponseEntity.status(HttpStatus.OK).body(patientResponse);
        }
    }
}