
package com.patientservice.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VisitNoteConfig {

    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }    
}
