package com.firatyildiz.LanguageSchoolManagement.service;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ManagerRequestDto.SaveManagerRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ManagerRequestDto.UpdateManagerRequestDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Manager;
import com.firatyildiz.LanguageSchoolManagement.repository.ManagerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ManagerServiceImplTest {

    @InjectMocks
    ManagerServiceImpl managerService;

    @Mock
    ManagerRepository managerRepository;

    @Mock
    ModelMapper modelMapper;
    @Test
    void testSaveManager()
    {
        SaveManagerRequestDto saveManagerRequestDtoMock = mock(SaveManagerRequestDto.class);
        saveManagerRequestDtoMock.setName("test");
        saveManagerRequestDtoMock.setLastname("test");

        Manager managerMock = mock(Manager.class);
        managerMock.setId(1);
        managerMock.setIdentityCardNo(123);
        managerMock.setName("testName");
        managerMock.setLastname("testLastname");

        when(modelMapper.map(saveManagerRequestDtoMock, Manager.class)).thenReturn(managerMock);
        when(managerRepository.save(managerMock)).thenReturn(managerMock);

        String saveManager = managerService.saveManager(saveManagerRequestDtoMock);
        String saveManagerMessage = "Manager Has Been Created.";

        assertEquals(saveManagerMessage, saveManager);
    }

    @Test
    void testFindManagerById()
    {
        Manager managerMock = mock(Manager.class);
        managerMock.setId(1);
        managerMock.setIdentityCardNo(123);
        managerMock.setName("testName");
        managerMock.setLastname("testLastname");

        when(managerRepository.findById(managerMock.getId())).thenReturn(Optional.of(managerMock));
        Manager findManager = managerService.findManagerById(managerMock.getId());

        assertEquals(managerMock, findManager);
    }

    @Test
    void testUpdateManagerById()
    {
        UpdateManagerRequestDto updateManagerRequestDtoMock = mock(UpdateManagerRequestDto.class);
        updateManagerRequestDtoMock.setId(1);
        updateManagerRequestDtoMock.setName("test");
        updateManagerRequestDtoMock.setLastname("test");

        Manager managerMock = mock(Manager.class);
        managerMock.setId(1);
        managerMock.setIdentityCardNo(123);
        managerMock.setName("testName");
        managerMock.setLastname("testLastname");

        when(managerRepository.findById(updateManagerRequestDtoMock.getId())).thenReturn(Optional.of(managerMock));
        when(modelMapper.map(updateManagerRequestDtoMock, Manager.class)).thenReturn(managerMock);
        when(managerRepository.save(managerMock)).thenReturn(managerMock);

        String updateManager = managerService.updateManagerById(updateManagerRequestDtoMock);
        String updateManagerMessage = "Changes Saved.";

        assertEquals(updateManagerMessage, updateManager);
    }

    @Test
    void testDeleteManagerById()
    {
        Manager managerMock = mock(Manager.class);
        managerMock.setId(1);
        managerMock.setIdentityCardNo(123);
        managerMock.setName("testName");
        managerMock.setLastname("testLastname");

        when(managerRepository.findById(managerMock.getId())).thenReturn(Optional.of(managerMock));
        String deleteManager = managerService.deleteManagerById(managerMock.getId());
        String deleteManagerMessage = "The Manager Deleted.";

        assertEquals(deleteManagerMessage, deleteManager);
    }
}