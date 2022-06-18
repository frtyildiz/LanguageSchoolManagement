package com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.CourseRequestDto;

import com.firatyildiz.LanguageSchoolManagement.entity.Classroom;
import com.firatyildiz.LanguageSchoolManagement.entity.Teacher;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SaveCourseWithoutStudentRequestDto {

    private long id;


    private String courseName;


    private String courseLevel;


    private LocalDate startDate;


    private LocalDate endDate;


    private byte[] materials;


    private Classroom classroom;


    private Teacher teacher;
}
