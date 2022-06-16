package com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ClassroomRequestDto;

import lombok.Data;

@Data
public class AddCourseToClassroomRequestDto {

    long classroomId;

    long courseId;
}
