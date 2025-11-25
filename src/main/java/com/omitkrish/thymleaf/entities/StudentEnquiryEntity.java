package com.omitkrish.thymleaf.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "student_enquiry")
public class StudentEnquiryEntity extends SubclassCommonProperties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer id;

    @Column(name = "student_name")
    private String name;

    @Column(name = "student_courseName")
    private String courseName;

    @Column(name = "student_exp")
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
        return "StudentEnquiryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courseName='" + courseName + '\'' +
                ", exp=" + exp +
                '}';
    }
}
