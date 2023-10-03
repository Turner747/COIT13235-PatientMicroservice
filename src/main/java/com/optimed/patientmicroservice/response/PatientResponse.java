
package com.optimed.patientmicroservice.response;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
public class PatientResponse {
    
    private Long id;
    private String firstName;
    private String surname;
    private Date dateOfBirth;
    private String phoneNbr;
    private String emailAddress;
    
    private String street;
    private String suburb;
    private String state;
    private String postcode;
    
    private Date creationDate;
    private Date updatedDate;
    
    private ConditionResponse condition;
    private VisitNoteResponse visit_note;
 
}
