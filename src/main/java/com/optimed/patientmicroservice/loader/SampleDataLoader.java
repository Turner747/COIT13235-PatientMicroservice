package com.optimed.patientmicroservice.loader;

import com.optimed.patientmicroservice.model.Patient;
import com.optimed.patientmicroservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SampleDataLoader implements ApplicationRunner {

    @Autowired
    PatientRepository patientRepo;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        createPatient("Test",
                "Test",
                new Date(),
                "Test",
                "Test",
                "Test",
                "Test",
                "Test",
                "Test");
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
}
