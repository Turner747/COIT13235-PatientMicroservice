
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
@RequestMapping("/visit-notes")
public class VisitNoteController {
    
    private VisitNoteRepository visitNoteRepo;
    
    @PostMapping(consumes = "application/json")
    public ResponseEntity<VisitNoteResponse> saveVisitNote(@RequestBody VisitNoteResponse visitNoteResponse) {
        VisitNote new_visitNote = visitNoteRepo.save(ObjectMapper.map(visitNoteResponse, VisitNote.class));
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
   
    @GetMapping("delete/{id}")
    public ResponseEntity<VisitNoteResponse> deleteVisitNoteById(@PathVariable("id") Long id) {
        Optional<VisitNote> optional = visitNoteRepo.findById(id);
        
        if (optional.isPresent()) {
            visitNoteRepo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
