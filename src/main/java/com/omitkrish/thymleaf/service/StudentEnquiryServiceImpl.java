package com.omitkrish.thymleaf.service;

import com.omitkrish.thymleaf.entities.StudentEnquiryEntity;
import com.omitkrish.thymleaf.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.omitkrish.thymleaf.DTOs.StudentEnquiryDTO;

@Service
public class StudentEnquiryServiceImpl implements StudentEnquiryService {


    private StudentRepository studentRepository;

    private ModelMapper modelMapper;

    public StudentEnquiryServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String saveStudent(StudentEnquiryDTO studentEnquiryDTO) {

        StudentEnquiryEntity studentEnquiry = modelMapper.map(studentEnquiryDTO, StudentEnquiryEntity.class);

        StudentEnquiryEntity studentEnquiryEntity = studentRepository.save(studentEnquiry);

        return (studentEnquiryEntity!=null)?"success":"failure";
    }
}
