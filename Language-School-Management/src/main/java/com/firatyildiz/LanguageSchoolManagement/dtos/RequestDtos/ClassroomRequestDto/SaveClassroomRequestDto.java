package com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ClassroomRequestDto;

import lombok.Data;

@Data
public class SaveClassroomRequestDto {

    private String classroomName;

    private byte capacity;
}
