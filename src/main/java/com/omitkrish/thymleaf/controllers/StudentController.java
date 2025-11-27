package com.omitkrish.thymleaf.controllers;

import com.omitkrish.thymleaf.DTOs.StudentEnquiryDTO1;
import com.omitkrish.thymleaf.DTOs.StudentPageBundle;
import com.omitkrish.thymleaf.service.StudentEnquiryService;
import org.hibernate.Internal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentEnquiryService studentEnquiryService;

    @GetMapping(value = {"/", "/welcome"})
    public String welcome() {
        System.out.println("inside welcome method");
        return "welcome";
    }

    @GetMapping(value = "/student-list")
    public String studentList(@RequestParam(name = "pageNumber", required = false) Integer pageNumber,
                              @RequestParam(name = "studentName", required = false) String studentName,
                              @RequestParam(name = "sortBy", required = false) String orderBy, Model model) {
        StudentPageBundle studentPageBundle = null;
        if (pageNumber != null) {
            studentPageBundle = studentEnquiryService.findAllStudents(pageNumber, studentName, orderBy);

        } else {
            studentPageBundle = studentEnquiryService.findAllStudents(1, studentName, orderBy);
        }
        List<StudentEnquiryDTO1> studentEnquiryDTO1s = studentPageBundle.getStudentEnquiryDTO1s();

        model.addAttribute("allStudents", studentEnquiryDTO1s);
        model.addAttribute("studentPageable", studentPageBundle.getStudentPageable());
        String toggler = orderBy.equals("asc") ? "desc" : "asc";
        model.addAttribute("sortBy", toggler);

        return "student-list";

    }

    @GetMapping(value = "/student-page-wise-list")
    public String studentPagewiseList(@RequestParam("pageNumber") Integer pageNumber, Model model) {
        System.out.println("inside student page wise list method " + pageNumber);
        return studentList(pageNumber, "name", "asc", model);
    }

//print student-list as well first page studentName, sort by asc or dec order,


    @GetMapping("/student-list-by-conditions")
    public String studentListByStudentNameAndAscOrDescAndPageNumber(@RequestParam(name = "pageNumber", required = false) Integer pageNumber,
                                                                    @RequestParam(name = "studentName") String studentName,
                                                                    @RequestParam(name = "sortBy") String orderBy, Model model) {

        return studentList(pageNumber, studentName, orderBy, model);
    }

    @GetMapping("/student-page")
    public String studentShowPage(@ModelAttribute("studentEnquiryDTO1") StudentEnquiryDTO1 studentEnquiryDTO1) {

        return "student-show-page";
    }


    @PostMapping(value = "/submit-student")
    public String submitStudent(StudentEnquiryDTO1 studentEnquiryDTO1) {

        String s = studentEnquiryService.saveStudent(studentEnquiryDTO1);
        System.out.println("inside submit student method and status is :  " + s);
        return "redirect:/student-list";
    }


    @GetMapping(value = "/update-student")
    public String updateStudent(@RequestParam("studentId") Integer studentId, Model model) {
        StudentEnquiryDTO1 enquiryServiceById = studentEnquiryService.findById(studentId);
        model.addAttribute("studentEnquiryDTO1", enquiryServiceById);
        return "student-show-page";
    }
}
