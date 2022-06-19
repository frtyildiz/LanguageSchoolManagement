package com.firatyildiz.LanguageSchoolManagement.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "identity_no")
    private long identityCardNumber;

    @Column(name = "name", length = 75)
    @NotNull
    private String name;

    @NotNull
    @Column(name = "surname", length = 75)
    private String lastname;

    @NotNull
    @Positive
    @Column(name = "salary")
    private int salary;

    @NotNull
    @Column(name = "major", length = 75)
    private String major;

    @Column(name = "phone_number", length = 10)
    private int phoneNo;

    @Column(name = "address", length = 150)
    private String address;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "email", length = 75)
    @Email(message = "Email is mandatory")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teacher")
    private List<Course> courses = new ArrayList<>();
}
