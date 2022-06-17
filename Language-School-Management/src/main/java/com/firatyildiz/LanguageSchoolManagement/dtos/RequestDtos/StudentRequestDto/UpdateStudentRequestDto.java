package com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.StudentRequestDto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateStudentRequestDto {

    private long id;

    private int identityCardNo;

    private String name;

    private String lastname;

    private int phoneNumber;

    private String address;

    private LocalDate birthday;

    private String email;
}
