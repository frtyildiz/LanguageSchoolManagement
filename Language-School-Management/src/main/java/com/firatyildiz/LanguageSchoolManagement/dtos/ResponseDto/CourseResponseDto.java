package com.firatyildiz.LanguageSchoolManagement.dtos.ResponseDto;

import com.firatyildiz.LanguageSchoolManagement.entity.Classroom;
import com.firatyildiz.LanguageSchoolManagement.entity.Teacher;

import java.time.LocalDate;

public class CourseResponseDto {

    private long id;


    private String courseName;


    private String courseLevel;


    private LocalDate startDate;


    private LocalDate endDate;


    private Classroom classroom;


    private Teacher teacher;

}
