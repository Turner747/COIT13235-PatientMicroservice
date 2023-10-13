
package com.optimed.patientmicroservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.optimed.patientmicroservice.response.StaffResponse;
import jakarta.persistence.*;
import java.util.Date;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "condition")
public class Condition {

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
    
    @Column(name = "diagnosis", nullable = false)
    private String diagnosis;
    
    @Column(name = "notes", nullable = false)
    private String notes;
    
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "diagnosis_date", nullable = false)
    private Date diagnosisDate;

}