
package com.optimed.patientmicroservice.response;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

@Data
@Embeddable
public class PatientResponse {
    
    private Long id;
    private String first_name;
    private String surname;
    
    @Temporal(TemporalType.DATE)
    private Date date_of_birth;
    
    private String phone_number;
    
    private String email_address;
    
    private String street;
    
    private String suburb;
    
    private String state;
    
    private String postcode;
}
