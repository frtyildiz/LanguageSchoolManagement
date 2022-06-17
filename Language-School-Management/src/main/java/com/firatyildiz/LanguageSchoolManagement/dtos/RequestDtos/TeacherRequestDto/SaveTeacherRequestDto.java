package com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.TeacherRequestDto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
public class SaveTeacherRequestDto {

    private long identityCardNumber;

    private String name;

    private String surname;

    private int salary;

    private String major;

    private int phoneNo;


    private String address;


    private LocalDate birthday;


    private String email;
}
