package com.omitkrish.thymleaf.DTOs;

import com.omitkrish.thymleaf.pageable.StudentPageable;

import java.util.List;

public class StudentPageBundle {


    private StudentPageable studentPageable;

    private List<StudentEnquiryDTO1> studentEnquiryDTO1s;

    public StudentPageable getStudentPageable() {
        return studentPageable;
    }

    public void setStudentPageable(StudentPageable studentPageable) {
        this.studentPageable = studentPageable;
    }

    public List<StudentEnquiryDTO1> getStudentEnquiryDTO1s() {
        return studentEnquiryDTO1s;
    }

    public void setStudentEnquiryDTO1s(List<StudentEnquiryDTO1> studentEnquiryDTO1s) {
        this.studentEnquiryDTO1s = studentEnquiryDTO1s;
    }

    @Override
    public String toString() {
        return "StudentPageBundle{" +
                "studentPageable=" + studentPageable +
                ", studentEnquiryDTO1s=" + studentEnquiryDTO1s +
                '}';
    }
}
