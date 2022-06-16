package com.firatyildiz.LanguageSchoolManagement.service;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ManagerRequestDto.SaveManagerRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ManagerRequestDto.UpdateManagerRequestDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Manager;
import com.firatyildiz.LanguageSchoolManagement.repository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final ManagerRepository managerRepository;

    private final ModelMapper modelMapper;

    @Transactional
    public String saveManager(SaveManagerRequestDto saveManagerRequestDto)
    {
        Manager manager = modelMapper.map(saveManagerRequestDto, Manager.class);

        manager = managerRepository.save(manager);

        return "Manager Has Been Created.";
    }

    @Transactional
    public Manager findManagerById (Long managerId)
    {
        return managerRepository.findById(managerId).get();
    }

    @Transactional
    public String updateManagerNameAndLastnameById(UpdateManagerRequestDto updateManagerRequestDto)
    {
        long updateManagerRequestId = updateManagerRequestDto.getId();
        Optional<Manager> managerOptional = managerRepository.findById(updateManagerRequestId);
        Manager manager = managerOptional.get();

        manager = modelMapper.map(updateManagerRequestDto, Manager.class);

        managerRepository.save(manager);

        return "Changes Saved.";
    }

    @Transactional
    public String deleteManagerById(Long managerId)
    {
        Manager manager = managerRepository.findById(managerId).get();

        managerRepository.delete(manager);

        return "The Manager Deleted.";
    }


}
