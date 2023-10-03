
package com.patientservice.model;

import com.patientservice.response.ConditionResponse;
import com.patientservice.response.VisitNoteResponse;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @Column(name = "surname", nullable = false)
    private String surname;
    
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;
    
    @Column(name = "phone_number", nullable = false)
    private String phoneNbr;
    
    @Column(name = "email_address", nullable = false)
    private String emailAddress;
    
    @Column(name = "street", nullable = false)
    private String street;
    
    @Column(name = "suburb", nullable = false)
    private String suburb;
    
    @Column(name = "state", nullable = false)
    private String state;
    
    @Column(name = "postcode", nullable = false)
    private String postcode;
    
    @Column(name = "creation_date", nullable = false)
    private Date creationDate;
    
    @Column(name = "updated_date", nullable = false)
    private Date updatedDate;
    
    private ConditionResponse condition;

    private VisitNoteResponse visit_note;
    
    //Getters
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNbr() {
        return phoneNbr;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getStreet() {
        return street;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getState() {
        return state;
    }

    public String getPostcode() {
        return postcode;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public ConditionResponse getCondition() {
        return condition;
    }

    public VisitNoteResponse getVisit_note() {
        return visit_note;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhoneNbr(String phoneNbr) {
        this.phoneNbr = phoneNbr;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setCondition(ConditionResponse condition) {
        this.condition = condition;
    }

    public void setVisit_note(VisitNoteResponse visit_note) {
        this.visit_note = visit_note;
    }
    
}