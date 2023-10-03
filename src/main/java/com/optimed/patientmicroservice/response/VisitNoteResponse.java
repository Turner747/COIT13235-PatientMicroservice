
package com.optimed.patientmicroservice.response;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
public class VisitNoteResponse {

    private Long id;
    
    private StaffResponse doctor;
    private PatientResponse patient;
    
    private String content;
    private Date visitDate;
    private Date creationDate;
    private Date updatedDate;

}
