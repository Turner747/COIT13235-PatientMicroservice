
package com.patientservice.response;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

public class ConditionResponse {

    private Long id;
    
    private StaffResponse doctor;
    private PatientResponse patient;
    
    private String diagnosis;
    private Date diagnosisDate;
    private Date creationDate;
    private Date updatedDate;

}
