package com.firatyildiz.LanguageSchoolManagement.service;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDto.SaveManagerRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDto.UpdateManagerNameAndLastnameRequestDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Manager;
import com.firatyildiz.LanguageSchoolManagement.repository.ManagerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Manager findManagerById (Long managerId)
    {
        return managerRepository.findById(managerId).get();
    }

    public String updateManagerNameAndLastnameById(UpdateManagerNameAndLastnameRequestDto updateManagerRequestDto)
    {
        long updateManagerRequestId = updateManagerRequestDto.getId();
        Optional<Manager> managerOptional = managerRepository.findById(updateManagerRequestId);
        Manager manager = managerOptional.get();

        String nameManagerRequest = updateManagerRequestDto.getName();
        String lastnameManagerRequest = updateManagerRequestDto.getLastname();

        manager.setName(nameManagerRequest);
        manager.setLastname(lastnameManagerRequest);

        managerRepository.save(manager);

        return "Changes Saved.";
    }

}
