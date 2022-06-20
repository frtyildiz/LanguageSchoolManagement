package com.firatyildiz.LanguageSchoolManagement.dtos.ResponseDto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TeacherResponseDto {

    private long id;

    private long identityCardNumber;

    private String name;

    private String lastname;

    private int salary;

    private String major;

    private int phoneNo;

    private String address;

    private LocalDate birthday;

    private String email;
}
