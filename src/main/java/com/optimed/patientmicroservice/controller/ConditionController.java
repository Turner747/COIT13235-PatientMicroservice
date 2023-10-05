
package com.optimed.patientmicroservice.controller;

import com.optimed.patientmicroservice.mapper.ObjectMapper;
import com.optimed.patientmicroservice.model.Condition;
import com.optimed.patientmicroservice.response.ConditionResponse;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.optimed.patientmicroservice.repository.ConditionRepository;

@RestController
@AllArgsConstructor
@RequestMapping("/patient/conditions")
public class ConditionController {
    
    private ConditionRepository conditionRepo;
    
    @PostMapping
    public ResponseEntity<ConditionResponse> saveCondition(@RequestBody Condition condition) {
        Condition new_condition = conditionRepo.save(condition);
    
        return ResponseEntity.status(HttpStatus.CREATED).body(ObjectMapper.map(new_condition, ConditionResponse.class));
    }
    
    @GetMapping
    public ResponseEntity<Collection<ConditionResponse>> getAllConditions() {
        List<Condition> conditions = conditionRepo.findAll();
        
        if(conditions.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            List<ConditionResponse> conditionResponse = ObjectMapper.mapAll(conditions, ConditionResponse.class);
            
            return ResponseEntity.status(HttpStatus.OK).body(conditionResponse);
        }
    }
        
    @GetMapping("/id/{id}")
    public ResponseEntity<ConditionResponse> getConditionById(@PathVariable("id") Long id) {
        Optional<Condition> optional = conditionRepo.findById(id);
        
        if(optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            ConditionResponse conditionResponse = ObjectMapper.map(optional, ConditionResponse.class);
            
            return ResponseEntity.status(HttpStatus.OK).body(conditionResponse);
        }
    }
    
    @PutMapping("/id/{id}")
    public ResponseEntity<ConditionResponse> updateCondition(@PathVariable Long id, @RequestBody Condition updatedCondition) {
        Optional<Condition> optional = conditionRepo.findById(id);
        
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            Condition existingCondition = optional.get();
            existingCondition = ObjectMapper.map(updatedCondition, Condition.class);
            ConditionResponse conditionResponse = ObjectMapper.map(conditionRepo.save(existingCondition), ConditionResponse.class);

            return ResponseEntity.status(HttpStatus.OK).body(conditionResponse);
        }
    }
}