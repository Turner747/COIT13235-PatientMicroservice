
package com.patientservice.service;

import com.patientservice.model.Patient;
import com.patientservice.exception.RecordNotFoundException;
import com.patientservice.response.PatientResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import com.patientservice.repository.PatientRepository;

@Service
public class PatientService {
    
    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private ModelMapper mapper;
    
    public PatientService(PatientRepository patientRepo) {
        super();
        this.patientRepo = patientRepo;
    }
    
    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    public Patient savePatient(Patient patient) {
        return patientRepo.save(patient);
    }

    public PatientResponse getPatientById(int id) throws RecordNotFoundException {
        Optional<Patient> patient = patientRepo.findById(id);
        
        PatientResponse patientResponse = mapper.map(patient,
            PatientResponse.class);
        
        if(patient.isPresent())
            return patientResponse;
        else {
            throw new RecordNotFoundException("Patient record not found.");
        }
    }

}