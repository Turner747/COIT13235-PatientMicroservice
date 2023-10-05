
package com.optimed.patientmicroservice.response;

import jakarta.persistence.*;
import java.util.Date;
import lombok.Data;

@Data
@Embeddable
public class StaffResponse {
    
    @Column(name = "staff_id")
    private Long id;
    
    @Column(name = "staff_first_name")
    private String first_name;
    
    @Column(name = "staff_surname")
    private String surname;
    
    /*
    @Temporal(TemporalType.DATE)
    @Column(name = "staff_date_of_birth")
    private Date date_of_birth;
    
    @Column(name = "staff_phone_street")
    private String street;
    
    @Column(name = "staff_phone_suburb")
    private String suburb;
    
    @Column(name = "staff_phone_state")
    private String state;
    
    @Column(name = "staff_postcode")
    private String postcode;
    
    @Column(name = "staff_phone_number")
    private String phone_number;
    
    @Column(name = "staff_email_address")
    private String email_address;
    
    @Column(name = "staff_provider_number")
    private String provider_number;
    
    @Column(name = "staff_prescriber_number")
    private String prescriber_number;
    */
}
