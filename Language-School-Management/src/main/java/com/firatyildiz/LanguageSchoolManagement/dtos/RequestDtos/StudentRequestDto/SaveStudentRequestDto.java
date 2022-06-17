package com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.StudentRequestDto;

import com.firatyildiz.LanguageSchoolManagement.entity.Course;
import lombok.Data;

import java.time.LocalDate;


@Data
public class SaveStudentRequestDto {

    private int identityCardNo;

    private String name;

    private String lastname;

    private int phoneNumber;

    private String address;

    private LocalDate birthday;

    private String email;

}
