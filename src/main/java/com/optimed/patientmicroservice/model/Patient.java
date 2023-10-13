
package com.optimed.patientmicroservice.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient")
public class Patient implements Serializable  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @Column(name = "surname", nullable = false)
    private String surname;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
    
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonIgnore
    @Column(name = "creation_date", nullable = false)
    private Date creationDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @JsonIgnore
    @Column(name = "updated_date", nullable = false)
    private Date updatedDate;
   
}
