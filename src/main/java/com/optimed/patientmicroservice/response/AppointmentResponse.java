
package com.optimed.patientmicroservice.response;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Embeddable
public class AppointmentResponse {
    
    @Column(name = "appointment_id")
    private Long id;
    
    private PatientResponse patient;
    
    private StaffResponse doctor;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "appointment_start_time")
    private Date start_time;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "appointment_end_time")
    private Date end_time;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "appointment_status")
    private AppointmentResponse status;
    
}
