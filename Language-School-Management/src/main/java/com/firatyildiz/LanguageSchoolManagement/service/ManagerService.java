package com.firatyildiz.LanguageSchoolManagement.service;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ManagerRequestDto.SaveManagerRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ManagerRequestDto.UpdateManagerRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.ResponseDto.ManagerResponseDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Manager;

import java.util.List;

public interface ManagerService {

    String saveManager(SaveManagerRequestDto saveManagerRequestDto);

    Manager findManagerById (Long managerId);

    String updateManagerById(UpdateManagerRequestDto updateManagerRequestDto);

    String deleteManagerById(Long managerId);

    List<ManagerResponseDto> findAllManager();
}
