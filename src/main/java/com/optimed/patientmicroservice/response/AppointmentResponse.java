
package com.optimed.patientmicroservice.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Embeddable
public class AppointmentResponse {
    
    @Column(name = "appointment_id")
    private Long id;
    @JsonProperty("patient")
    private PatientResponse patient;
    @JsonProperty("doctor")
    private StaffResponse doctor;
    
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "appointment_start_time")
    private Date startTime;
    
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "appointment_end_time")
    private Date finishTime;
    
//    @Enumerated(EnumType.STRING)
    @Column(name = "appointment_status")
//    private AppointmentResponse status;
    private String status;
}
