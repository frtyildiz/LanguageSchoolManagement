package com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ManagerRequestDto;

import lombok.Data;

@Data
public class UpdateManagerPhoneRequestDto {

    private long id;

    private int phoneNumber;
}
