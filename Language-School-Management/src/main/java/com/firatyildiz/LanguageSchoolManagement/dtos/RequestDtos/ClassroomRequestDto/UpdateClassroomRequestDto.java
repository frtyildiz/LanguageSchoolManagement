package com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ClassroomRequestDto;

import lombok.Data;


@Data
public class UpdateClassroomRequestDto {

    private long id;

    private String classroomName;

    private byte capacity;
}
