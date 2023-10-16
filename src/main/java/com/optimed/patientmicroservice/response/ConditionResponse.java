
package com.optimed.patientmicroservice.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Embeddable
public class ConditionResponse {
    
    private Long id;
    @JsonProperty("doctor")
    private StaffResponse doctor;
    @JsonProperty("patient")
    private PatientResponse patient;
    private String diagnosis;
    private String notes;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date diagnosisDate;
}
