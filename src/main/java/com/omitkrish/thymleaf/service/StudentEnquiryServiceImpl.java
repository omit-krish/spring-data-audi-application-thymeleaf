package com.omitkrish.thymleaf.service;

import com.omitkrish.thymleaf.DTOs.StudentEnquiryDTO1;
import com.omitkrish.thymleaf.DTOs.StudentPageBundle;
import com.omitkrish.thymleaf.entities.StudentEnquiryEntity;
import com.omitkrish.thymleaf.pageable.StudentPageable;
import com.omitkrish.thymleaf.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentEnquiryServiceImpl implements StudentEnquiryService {


    private StudentRepository studentRepository;

    private ModelMapper modelMapper;

    public StudentEnquiryServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String saveStudent(StudentEnquiryDTO1 studentEnquiryDTO1) {
//        modelMapper.getConfiguration().setSkipNullEnabled(true);

        StudentEnquiryEntity studentEnquiry = modelMapper.map(studentEnquiryDTO1, StudentEnquiryEntity.class);

        StudentEnquiryEntity studentEnquiryEntity = studentRepository.save(studentEnquiry);

        return (studentEnquiryEntity != null) ? "success" : "failure";
    }

    @Override
    public StudentPageBundle findAllStudents(int PageNumber,String studentName,String orderBy) {


        Sort sortByOrder = Sort.by("name").and(Sort.by("courseName")).and(Sort.by("exp"));

        sortByOrder = orderBy.equals("asc") ? sortByOrder.ascending() : sortByOrder.descending();

        Pageable pageable = PageRequest.of(--PageNumber,2,sortByOrder);

        Page<StudentEnquiryEntity> studentEnquiryEntityPage = studentRepository.findAll(pageable);

        List<StudentEnquiryEntity> studentEnquiryEntityList = studentEnquiryEntityPage.getContent();
        StudentEnquiryDTO1[] studentEnquiryDTO1s = modelMapper.map(studentEnquiryEntityList, StudentEnquiryDTO1[].class);

        //assign all pageable values to studentPageable
        StudentPageBundle studentPageBundle = getStudentPageBundle(studentEnquiryEntityPage, studentEnquiryDTO1s);
        return studentPageBundle;
    }

    //extract method
    private static StudentPageBundle getStudentPageBundle(Page<StudentEnquiryEntity> studentEnquiryEntityPage, StudentEnquiryDTO1[] studentEnquiryDTO1s) {
        StudentPageable studentPageable = new StudentPageable();
        studentPageable.setTotalStudents(studentEnquiryEntityPage.getTotalElements());
        studentPageable.setPageSize(studentEnquiryEntityPage.getSize());
        studentPageable.setCurrentPage(studentEnquiryEntityPage.getNumber()+1);
        studentPageable.setTotalPages(studentEnquiryEntityPage.getTotalPages());
        StudentPageBundle studentPageBundle = new StudentPageBundle();

        studentPageBundle.setStudentEnquiryDTO1s(Arrays.asList(studentEnquiryDTO1s));
        studentPageBundle.setStudentPageable(studentPageable);
        return studentPageBundle;
    }


    @Override
    public StudentEnquiryDTO1 findById(Integer studentId) {
        Optional<StudentEnquiryEntity> studentEnquiry = studentRepository.findById(studentId);
        StudentEnquiryDTO1 studentEnquiryDTO1 = null;
        if (studentEnquiry.isPresent()) {

            StudentEnquiryEntity studentEnquiryEntity = studentEnquiry.get();

            studentEnquiryDTO1 = modelMapper.map(studentEnquiryEntity, StudentEnquiryDTO1.class);

            System.out.println(studentEnquiryDTO1);

        }

        return studentEnquiryDTO1;


    }
}
