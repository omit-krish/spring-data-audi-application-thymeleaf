package com.omitkrish.thymleaf.service;

import com.omitkrish.thymleaf.DTOs.StudentEnquiryDTO1;
import com.omitkrish.thymleaf.DTOs.StudentPageBundle;

import java.util.List;

public interface StudentEnquiryService {

    String saveStudent(StudentEnquiryDTO1 studentEnquiryDTO1);

    StudentPageBundle findAllStudents(int pageNumber,String studentName,String orderBy);

    StudentEnquiryDTO1 findById(Integer studentId);
}
