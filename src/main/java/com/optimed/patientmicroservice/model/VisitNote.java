
package com.optimed.patientmicroservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.optimed.patientmicroservice.response.StaffResponse;
import jakarta.persistence.*;
import java.util.Date;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "visit_note")
public class VisitNote  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    @JsonManagedReference
    private Patient patient;
    
    @Embedded
    private StaffResponse doctor;
    
    @Column(name = "content", nullable = false)
    private String content;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "visit_date", nullable = false)
    private Date visitDate;
    
}
