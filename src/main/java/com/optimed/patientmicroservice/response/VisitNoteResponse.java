
package com.optimed.patientmicroservice.response;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Embeddable
public class VisitNoteResponse {

    private Long id;
    
    private StaffResponse doctor;
    private PatientResponse patient;
    
    private String content;
    private Date visit_date;

}
