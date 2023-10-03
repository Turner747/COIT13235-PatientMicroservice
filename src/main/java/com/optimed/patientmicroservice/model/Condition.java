
package com.optimed.patientmicroservice.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "condition")
public class Condition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "diagnosis", nullable = false)
    private String diagnosis;
    
    @Column(name = "diagnosis_date", nullable = false)
    private Date diagnosisDate;
    
    @Column(name = "creation_date", nullable = false)
    private Date creationDate;
    
    @Column(name = "updated_date", nullable = false)
    private Date updatedDate;
    
    private List<Patient> patient;
    
    //Getters
    public Long getId() {
        return id;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public List<Patient> getPatient() {
        return patient;
    }
    
    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setPatient(List<Patient> patient) {
        this.patient = patient;
    }
}
