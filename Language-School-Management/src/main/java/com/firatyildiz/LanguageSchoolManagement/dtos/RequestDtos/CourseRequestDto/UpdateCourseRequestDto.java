package com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.CourseRequestDto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateCourseRequestDto {

    private long id;

    private String courseName;

    private String courseLevel;

    private LocalDate startDate;

    private LocalDate endDate;

    private long classroomId;

    private long teacherId;
}