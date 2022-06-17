package com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.StudentRequestDto;

import lombok.Data;

@Data
public class AddCourseToStudentById {

    private long studentId;

    private long courseId;
}
