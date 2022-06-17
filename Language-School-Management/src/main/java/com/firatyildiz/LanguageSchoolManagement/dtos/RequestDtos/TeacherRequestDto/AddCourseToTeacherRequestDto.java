package com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.TeacherRequestDto;

import lombok.Data;

@Data
public class AddCourseToTeacherRequestDto {

    private long studentId;

    private long courseId;
}
