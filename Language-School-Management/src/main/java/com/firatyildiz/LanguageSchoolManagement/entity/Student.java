package com.firatyildiz.LanguageSchoolManagement.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "identity_cart_no")
    @NotNull
    private int identityCardNo;

    @Column(name = "name", length = 75)
    @NotNull
    private String name;

    @Column(name = "lastname", length = 75)
    @NotNull
    private String lastname;

    @Column(name = "phone_number", length = 11)
    private int phoneNumber;

    @Column(name = "address", length = 200)
    private String address;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "email")
    @Email(message = "Email is mandatory")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> courses = new ArrayList<>();
}