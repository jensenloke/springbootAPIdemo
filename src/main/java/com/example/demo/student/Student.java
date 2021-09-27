package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
//defines the entire student object
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName =  "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    public Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    //age will be calculated when Transient is defined
    private Integer age;

    //constructor with nothing
    public Student() {
    }

    //constructor with everything
    public Student(Long id,
                   String name,
                   String email,
                   LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    //constructor without ID as DB will generate.
    public Student(String name,
                   String email,
                   LocalDate dob) {
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
        return Period.between(this.dob, LocalDate.now()).getYears();
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

//***MY NOTES***//
//Amigos Code Tutorial Notes
//45:09 out of 1:37:30
//command for psql is psql -U jensen jensenDB
// \l check DB list
// \c check connection
// \d check relation
// \d student

//Test Post Request
//POST
//{
// "name":"Jeremy",
// "email":"jeremy@gmail.com",
// "dob":"1987-3-21"
//        }

//http://localhost:8080/api/v1/student
//student=# SELECT * FROM student;

//Check Port 8080 usage
//lsof -i :8080
//kill -9 <PID>

//How to send post request using Postman
//https://stackoverflow.com/questions/29364862/how-to-send-post-request-to-the-below-post-method-using-postman-rest-client/43108437

//DELETE student with ID1
//http://localhost:8080/api/v1/student/1
//PUT
//http://localhost:8080/api/v1/student/1?name=Maria&email=maria.tan@gmail.com

//Link: https://www.youtube.com/watch?v=9SGDpanrc8U
//Time Stopped: 1:29:48