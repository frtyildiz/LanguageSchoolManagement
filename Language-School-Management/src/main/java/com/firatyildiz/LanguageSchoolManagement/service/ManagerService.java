package com.firatyildiz.LanguageSchoolManagement.service;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ManagerRequestDto.SaveManagerRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ManagerRequestDto.UpdateManagerRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.ResponseDto.ManagerResponseDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Manager;

import java.util.List;

public interface ManagerService {

    public String saveManager(SaveManagerRequestDto saveManagerRequestDto);

    public Manager findManagerById (Long managerId);

    public String updateManagerNameAndLastnameById(UpdateManagerRequestDto updateManagerRequestDto);

    public String deleteManagerById(Long managerId);

    public List<ManagerResponseDto> findAllManager();
}
