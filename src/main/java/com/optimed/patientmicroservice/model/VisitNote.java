
package com.optimed.patientmicroservice.model;

import com.optimed.patientmicroservice.response.PatientResponse;
import com.optimed.patientmicroservice.response.StaffResponse;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "visit_note")
public class VisitNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "content", nullable = false)
    private String content;
    
    @Column(name = "visit_date", nullable = false)
    private Date visitDate;
    
    @Column(name = "creation_date", nullable = false)
    private Date creationDate;
    
    @Column(name = "updated_date", nullable = false)
    private Date updatedDate;

    private PatientResponse patient;
    
    private StaffResponse doctor;

    //Getters
    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public PatientResponse getPatient() {
        return patient;
    }

    public StaffResponse getDoctor() {
        return doctor;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setPatient(PatientResponse patient) {
        this.patient = patient;
    }

    public void setDoctor(StaffResponse doctor) {
        this.doctor = doctor;
    }

}
