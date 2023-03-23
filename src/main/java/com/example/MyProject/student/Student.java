package com.example.MyProject.student;

import jakarta.persistence.*;
// WE USE persistance because if we change from hibernate to another provider everything will still work.
import java.time.LocalDate;
import java.time.Period;

@Entity // for hibernate (ORM)
@Table // for table in our db
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence", // generator name
            sequenceName = "student_sequence", // (optional) primary key
            allocationSize = 1 // mostly 1
    )
    @GeneratedValue( // Entry point for primary key
            strategy = GenerationType.SEQUENCE, // (optional)
            generator = "student_sequence" // (optional) name of the primary generator. must be the same
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient // will be ignored when mapping. because we can calculate the age from DOB. No column in our DB
    private Integer age;
    // we dont put age in the constructor. we calculate age from DoB in getAge. And set the age with it
    public Student() {
    }

    public Student(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears(); // it will calculate the age
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
