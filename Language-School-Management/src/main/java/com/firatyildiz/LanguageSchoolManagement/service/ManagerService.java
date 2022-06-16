package com.firatyildiz.LanguageSchoolManagement.service;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDto.SaveManagerRequestDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Manager;
import com.firatyildiz.LanguageSchoolManagement.repository.ManagerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    ModelMapper modelMapper;

    public String saveManager(SaveManagerRequestDto saveManagerRequestDto)
    {
        Manager manager = modelMapper.map(saveManagerRequestDto, Manager.class);

        manager = managerRepository.save(manager);

        return "Manager Has Been Created.";
    }

    

}
