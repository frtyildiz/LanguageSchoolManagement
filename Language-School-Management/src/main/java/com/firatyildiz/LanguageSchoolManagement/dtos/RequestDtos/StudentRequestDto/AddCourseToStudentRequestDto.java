package com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.StudentRequestDto;

import lombok.Data;

@Data
public class AddCourseToStudentRequestDto {

    private long studentId;

    private long courseId;
}
