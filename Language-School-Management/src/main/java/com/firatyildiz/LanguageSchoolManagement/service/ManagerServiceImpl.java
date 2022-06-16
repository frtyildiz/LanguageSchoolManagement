package com.firatyildiz.LanguageSchoolManagement.service;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ManagerRequestDto.SaveManagerRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ManagerRequestDto.UpdateManagerRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.ResponseDto.ManagerResponseDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Manager;
import com.firatyildiz.LanguageSchoolManagement.repository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ManagerServiceImpl implements ManagerService{

    private final ManagerRepository managerRepository;

    private final ModelMapper modelMapper;

    public String saveManager(SaveManagerRequestDto saveManagerRequestDto)
    {
        Manager manager = modelMapper.map(saveManagerRequestDto, Manager.class);

        manager = managerRepository.save(manager);

        return "Manager Has Been Created.";
    }


    public Manager findManagerById (long managerId)
    {
        return managerRepository.findById(managerId).get();
    }


    public String updateManagerById(UpdateManagerRequestDto updateManagerRequestDto)
    {
        long updateManagerRequestId = updateManagerRequestDto.getId();
        Optional<Manager> managerOptional = managerRepository.findById(updateManagerRequestId);
        Manager manager = managerOptional.get();

        manager = modelMapper.map(updateManagerRequestDto, Manager.class);

        managerRepository.save(manager);

        return "Changes Saved.";
    }


    public String deleteManagerById(long managerId)
    {
        Optional<Manager> managerOptional = managerRepository.findById(managerId);
        Manager manager = managerOptional.get();
        managerRepository.delete(manager);

        return "The Manager Deleted.";
    }


    public List<ManagerResponseDto> findAllManager()
    {
        Iterable<Manager> managers = managerRepository.findAll();

        List<ManagerResponseDto> managerResponseDtos = new ArrayList<>();

        for (Manager manager : managers)
        {
            ManagerResponseDto managerResponseDto = modelMapper.map(manager, ManagerResponseDto.class);
            managerResponseDtos.add(managerResponseDto);
        }

        return managerResponseDtos;
    }

}
