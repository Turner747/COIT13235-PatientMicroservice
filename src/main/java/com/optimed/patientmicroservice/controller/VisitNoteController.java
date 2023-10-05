
package com.optimed.patientmicroservice.controller;

import com.optimed.patientmicroservice.mapper.ObjectMapper;
import com.optimed.patientmicroservice.model.Patient;
import com.optimed.patientmicroservice.model.VisitNote;
import com.optimed.patientmicroservice.repository.VisitNoteRepository;
import com.optimed.patientmicroservice.response.PatientResponse;
import com.optimed.patientmicroservice.response.VisitNoteResponse;

import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/patients/visit-notes")
public class VisitNoteController {
    
    private VisitNoteRepository visitNoteRepo;
    
    @PostMapping
    public ResponseEntity<VisitNoteResponse> saveVisitNote(@RequestBody VisitNote visitNote) {
        VisitNote new_visitNote = visitNoteRepo.save(visitNote);
    
        return ResponseEntity.status(HttpStatus.CREATED).body(ObjectMapper.map(new_visitNote, VisitNoteResponse.class));
    }
    
    @GetMapping
    public ResponseEntity<Collection<VisitNoteResponse>> getAllVisitNotes() {
        List<VisitNote> visitNote = visitNoteRepo.findAll();
        
        if(visitNote.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            List<VisitNoteResponse> visitNoteResponse = ObjectMapper.mapAll(visitNote, VisitNoteResponse.class);
            
            return ResponseEntity.status(HttpStatus.OK).body(visitNoteResponse);
        }
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<VisitNoteResponse> getVisitNotetById(@PathVariable("id") Long id) {
        Optional<VisitNote> optional = visitNoteRepo.findById(id);
        
        if(optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            VisitNoteResponse visitNoteResponse = ObjectMapper.map(optional, VisitNoteResponse.class);
            
            return ResponseEntity.status(HttpStatus.OK).body(visitNoteResponse);
        }
    }
    
   @PutMapping("/id/{id}")
    public ResponseEntity<VisitNoteResponse> updateVisitNote(@PathVariable Long id, @RequestBody VisitNote updatedVisitNote) {
        Optional<VisitNote> optional = visitNoteRepo.findById(id);
        
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            VisitNote existingVisitNote = optional.get();
            existingVisitNote = ObjectMapper.map(existingVisitNote, VisitNote.class);
            VisitNoteResponse visitNoteResponse = ObjectMapper.map(visitNoteRepo.save(existingVisitNote), VisitNoteResponse.class);

            return ResponseEntity.status(HttpStatus.OK).body(visitNoteResponse);
        }
    }
}
