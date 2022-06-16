package com.firatyildiz.LanguageSchoolManagement.controller;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ManagerRequestDto.SaveManagerRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ManagerRequestDto.UpdateManagerRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.ResponseDto.ManagerResponseDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Manager;
import com.firatyildiz.LanguageSchoolManagement.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Manager")
@RequiredArgsConstructor

public class ManagerController {

    private final ManagerService managerService;

    @PostMapping("/saveManager")
    public ResponseEntity<String> saveManager(@RequestBody SaveManagerRequestDto saveManagerRequestDto)
    {
        String saveText = managerService.saveManager(saveManagerRequestDto);

        return new ResponseEntity<>(saveText, HttpStatus.OK);
    }

    @GetMapping("/findManager")
    public ResponseEntity<Manager> findManagerById(@RequestParam Long managerId)
    {
        Manager manager = managerService.findManagerById(managerId);
        return new ResponseEntity<>(manager, HttpStatus.OK);
    }

    @PostMapping("/updateManager")
    public ResponseEntity<String> updateManagerNameAndLastName(@RequestBody UpdateManagerRequestDto updateManagerNameAndLastnameRequestDto)
    {
        String updateText = managerService.updateManagerNameAndLastnameById(updateManagerNameAndLastnameRequestDto);

        return new ResponseEntity<>(updateText, HttpStatus.OK);
    }

    @DeleteMapping("/deleteManager")
    ResponseEntity<String> deleteManagerById(@RequestParam Long managerId)
    {
        String deleteText = managerService.deleteManagerById(managerId);

        return new ResponseEntity<>(deleteText, HttpStatus.OK);
    }

    @GetMapping("/findAllManager")
    public ResponseEntity<List<ManagerResponseDto>> findAllManager()
    {
        List<ManagerResponseDto> managerResponseDtos = managerService.findAllManager();

        return new ResponseEntity<>(managerResponseDtos, HttpStatus.OK);
    }

}
