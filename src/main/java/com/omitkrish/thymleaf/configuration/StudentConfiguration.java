package com.omitkrish.thymleaf.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
public class StudentConfiguration {


    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }
//create and insert createdby ,updatedby
    @Bean
    public AuditorAware<String> auditorAware() {

        return () -> {

            String userName = (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) ? SecurityContextHolder.getContext().getAuthentication().getName() : null;


            return Optional.ofNullable(userName);
        };
    }
}
