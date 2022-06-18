package com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.CourseRequestDto;

import lombok.Data;

@Data
public class SaveStudentToCourseRequestDto {

    private long courseId;

    private long studentId;
}
