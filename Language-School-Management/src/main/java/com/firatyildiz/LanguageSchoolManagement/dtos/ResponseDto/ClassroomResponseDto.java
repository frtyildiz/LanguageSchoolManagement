package com.firatyildiz.LanguageSchoolManagement.dtos.ResponseDto;

import lombok.Data;


@Data
public class ClassroomResponseDto {

    private long id;

    private String classroomName;

    private byte capacity;
}
