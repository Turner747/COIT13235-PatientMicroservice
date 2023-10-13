
package com.optimed.patientmicroservice.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Embeddable
public class VisitNoteResponse {
    private Long id;
    @JsonProperty("doctor")
    private StaffResponse doctor;
    @JsonProperty("patient")
    private PatientResponse patient;
    private String content;
    private Date visit_date;

}
