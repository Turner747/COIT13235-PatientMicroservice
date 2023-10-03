
package com.patientservice.client;

import com.patientservice.response.AppointmentResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "appointment-service", url = "http://localhost:8082", path = "/")
public interface AppointmentClient {
    
    @GetMapping("/staffAddress/address/{id}")
    public ResponseEntity<AppointmentResponse> getAppointmentByPatientId(@PathVariable("id") Long
    id);
}
