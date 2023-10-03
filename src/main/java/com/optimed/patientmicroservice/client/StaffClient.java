
package com.patientservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "staff-service", url = "http://localhost:8083", path = "/")
public interface StaffClient {
    
    //Unsure on what mapping would need to be implemented here
}
