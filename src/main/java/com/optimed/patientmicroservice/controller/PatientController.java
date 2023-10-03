
package com.patientservice.controller;

import com.patientservice.model.Patient;
import com.patientservice.exception.RecordNotFoundException;
import com.patientservice.response.PatientResponse;
import com.patientservice.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.patientservice.repository.PatientRepository;

@RestController
@RequestMapping("/patients")
public class PatientController {
    
    @Autowired
    private PatientService patientService;
    
    @Autowired
    private PatientRepository patientRepo;
    
    public PatientController(PatientService patientService) {
        super();
        this.patientService = patientService;
    }

    @GetMapping("/all")
    public List<Patient> listPatients(){
        return patientService.getAllPatients();
        /*
        model.addAttribute("customers", patientService.getAllPatients());
        return patientService.getAllPatients();
        */
    }
    
    @GetMapping("/{id}")
    private ResponseEntity<PatientResponse> getPatientById(@PathVariable("id") int id) throws RecordNotFoundException {
        PatientResponse patient = patientService.getPatientById(id);
        return ResponseEntity.status(HttpStatus.OK).body(patient);
    }
    
    @GetMapping("/create")
    public String createPatientForm(Model model){
        Patient patient = new Patient();
        model.addAttribute("patient", patient);
        return "register_patient.hyml";
    }
    
    public String savePatient(@ModelAttribute("patient") Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/patients";
    }
    
    @GetMapping("/update/{id}")
    public String editPatientForm(@PathVariable int id, Model model) throws RecordNotFoundException {
        model.addAttribute("patient", patientService.getPatientById(id));

        //Patient update form
        return "update_patient.html";
    }
        
        /*
    @PostMapping("/{id}")
	public String updatePatient(@PathVariable int id,
			@ModelAttribute("patient") Patient patient,
			Model model) {
		
		PatientResponse existingPatient = patientService.getPatientById(id);
                
		existingPatient.setId(id);
		existingPatient.setFirstName(patient.getFirstName());
                existingPatient.setSurname(patient.getSurname());
                existingPatient.setDateOfBirth(patient.getDateOfBirth());
		existingPatient.setGender(patient.getGender());
                existingPatient.setPhoneNbr(patient.getPhoneNbr());
                existingPatient.setEmailAddress(patient.getEmailAddress());
                
                existingPatient.setAddressLine(patient.getAddressLine());
                existingPatient.setSuburb(patient.getSuburb());
                existingPatient.setPostcode(patient.getPostcode());
                existingPatient.setState(patient.getState());
                
                existingPatient.setEmergencyContactName(patient.getEmergencyContactName());
                existingPatient.setEmergencyContactNbr(patient.getEmergencyContactNbr());
                
                existingPatient.setMedicareNbr(patient.getMedicareNbr());
                existingPatient.setIRN(patient.getIRN());
                
		
		patientService.savePatient(existingPatient);
                
                
		return "redirect:/customers";		
	}
*/


}