
package com.optimed.patientmicroservice.response;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Embeddable
public class StaffResponse {
    
    private Long id;
    private String first_name;
    private String surname;
    private Date date_of_birth;
    
    private String street;
    private String suburb;
    private String state;
    private String postcode;
    
    private String phone_number;
    private String email_address;
    private String provider_number;
    private String prescriber_number;
    
    private Date creation_date;
    private Date updated_date;
    
}
