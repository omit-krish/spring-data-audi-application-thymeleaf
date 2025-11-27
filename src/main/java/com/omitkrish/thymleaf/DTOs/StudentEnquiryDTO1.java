package com.omitkrish.thymleaf.DTOs;

public class StudentEnquiryDTO1 {

    private Integer id;
    private String name;

    private String courseName;

    private Integer exp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
                "id=" + id +
                ", name='" + name + '\'' +
                ", courseName='" + courseName + '\'' +
                ", exp=" + exp +
                '}';
    }
}
