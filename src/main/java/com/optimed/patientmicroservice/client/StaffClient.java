
package com.optimed.patientmicroservice.client;

import com.optimed.patientmicroservice.response.StaffResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "staff-service", url = "http://localhost:8083", path = "/")
public interface StaffClient {
    @GetMapping("restapi/staffs/id/{id}")
    public ResponseEntity<StaffResponse> getStaffByID(@PathVariable("id") long id);
}
