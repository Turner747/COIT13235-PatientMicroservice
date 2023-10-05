
package com.optimed.patientmicroservice.response;

import jakarta.persistence.Embeddable;
import java.util.Date;
import lombok.Data;

@Data
@Embeddable
public class ConditionResponse {
    
    private Long id;
    
    private StaffResponse doctor;
    private PatientResponse patient;
    
    private String diagnosis;
    private String notes;
    private Date diagnosis_date;
}