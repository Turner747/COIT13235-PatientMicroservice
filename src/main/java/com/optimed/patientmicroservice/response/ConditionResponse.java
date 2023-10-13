
package com.optimed.patientmicroservice.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import java.util.Date;
import lombok.Data;

@Data
@Embeddable
public class ConditionResponse {
    
    private Long id;
    @JsonProperty("doctor")
    private StaffResponse doctor;
    @JsonProperty("doctor")
    private PatientResponse patient;
    private String diagnosis;
    private String notes;
    private Date diagnosis_date;
}