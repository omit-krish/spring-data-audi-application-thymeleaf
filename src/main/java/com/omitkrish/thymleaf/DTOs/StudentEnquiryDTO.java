package com.omitkrish.thymleaf.DTOs;

public class StudentEnquiryDTO {

    private String name;

    private String courseName;

    private Integer exp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "StudentEnquiryDTO{" +
                "name='" + name + '\'' +
                ", courseName='" + courseName + '\'' +
                ", exp=" + exp +
                '}';
    }
}
