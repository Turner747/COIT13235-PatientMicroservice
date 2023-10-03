
package com.optimed.patientmicroservice.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {

    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }    
}
