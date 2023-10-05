
package com.optimed.patientmicroservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "staff-service", url = "http://localhost:8083", path = "/")
public interface StaffClient {
    
    //
}
