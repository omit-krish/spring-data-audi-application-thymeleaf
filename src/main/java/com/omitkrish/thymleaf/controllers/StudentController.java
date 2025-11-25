package com.omitkrish.thymleaf.controllers;

import com.omitkrish.thymleaf.DTOs.StudentEnquiryDTO;
import com.omitkrish.thymleaf.service.StudentEnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentEnquiryService studentEnquiryService;

    @GetMapping(value = {"/","/welcome"})
    public  String welcome(){
        System.out.println("inside welcome method");
        return"welcome";
    }


    @GetMapping("/student-page")
    public String studentShowPage(@ModelAttribute("studentEnquiryDTO") StudentEnquiryDTO studentEnquiryDTO){

        return "student-show-page";
    }


@PostMapping(value="/submit-student")
    public String submitStudent(StudentEnquiryDTO studentEnquiryDTO){

    String s = studentEnquiryService.saveStudent(studentEnquiryDTO);
    System.out.println("inside submit student method and status is :  "+s);
    return"success-page";
}

}
