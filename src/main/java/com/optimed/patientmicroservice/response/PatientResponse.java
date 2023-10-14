package com.optimed.patientmicroservice.response;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.Data;

@Data
@Embeddable
public class PatientResponse {
    
    private Long id;
    private String firstName;
    private String surname;
    
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    
    private String phoneNbr;
    
    private String emailAddress;
    
    private String street;
    
    private String suburb;
    
    private String state;
    
    private String postcode;
        
}
