package com.optimed.patientmicroservice.loader;

import com.optimed.patientmicroservice.client.StaffClient;
import com.optimed.patientmicroservice.mapper.ObjectMapper;
import com.optimed.patientmicroservice.model.Condition;
import com.optimed.patientmicroservice.model.Patient;
import com.optimed.patientmicroservice.model.VisitNote;
import com.optimed.patientmicroservice.repository.ConditionRepository;
import com.optimed.patientmicroservice.repository.PatientRepository;
import com.optimed.patientmicroservice.repository.VisitNoteRepository;
import com.optimed.patientmicroservice.response.StaffResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@AllArgsConstructor
public class SampleDataLoader implements ApplicationRunner {

    @Autowired
    private PatientRepository patientRepo;
    @Autowired
    private ConditionRepository conditionRepo;

    @Autowired
    private VisitNoteRepository visitNoteRepo;

    @Autowired
    private StaffClient staffClient;

    @Override
    @Transactional
    public void run(ApplicationArguments args){
        Patient patient = createPatient("Test",
                "Test",
                new Date(),
                "Test",
                "Test",
                "Test",
                "Test",
                "Test",
                "Test");

        StaffResponse doctor = ObjectMapper.map(staffClient.getStaffByID(3L).getBody(), StaffResponse.class);

        createCondition(patient,
                doctor,
                "Diagnosis",
                "Some Notes",
                "2023-10-01");
    }

    public Patient createPatient(String firstName,
                                 String surname,
                                 Date dateOfBirth,
                                 String phoneNbr,
                                 String emailAddress,
                                 String street,
                                 String suburb,
                                 String state,
                                 String postcode) {
        Patient patient = new Patient();
        patient.setFirstName(firstName);
        patient.setSurname(surname);
        patient.setDateOfBirth(dateOfBirth);
        patient.setPhoneNbr(phoneNbr);
        patient.setEmailAddress(emailAddress);
        patient.setStreet(street);
        patient.setSuburb(suburb);
        patient.setState(state);
        patient.setPostcode(postcode);

        return patientRepo.save(patient);
    }

    public void createCondition(Patient patient,
                                StaffResponse doctor,
                                String diagnosis,
                                String notes,
                                String diagnosisDate) {
        String datePattern = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);

        Condition condition = new Condition();

        condition.setPatient(patient);
        condition.setDoctor(doctor);
        condition.setDiagnosis(diagnosis);
        condition.setNotes(notes);
        try {
            condition.setDiagnosisDate(dateFormat.parse(diagnosisDate));
        } catch (ParseException e) {
            System.out.println("Date format: yyyy-MM-dd");
        }

        conditionRepo.save(condition);
    }


}
