package com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ManagerRequestDto;

import lombok.Data;

@Data
public class UpdateManagerNameAndLastnameRequestDto {

    private long id;

    private String name;

    private String lastname;

}
