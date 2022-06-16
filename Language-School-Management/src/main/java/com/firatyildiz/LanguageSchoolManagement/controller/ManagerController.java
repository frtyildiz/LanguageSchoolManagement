package com.firatyildiz.LanguageSchoolManagement.controller;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ManagerRequestDto.SaveManagerRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ManagerRequestDto.UpdateManagerNameAndLastnameRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ManagerRequestDto.UpdateManagerPhoneRequestDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Manager;
import com.firatyildiz.LanguageSchoolManagement.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Manager")
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @PostMapping("/saveManager")
    public ResponseEntity<String> saveManager(@RequestBody SaveManagerRequestDto saveManagerRequestDto)
    {
        String saveText = managerService.saveManager(saveManagerRequestDto);

        return new ResponseEntity<>(saveText, HttpStatus.OK);
    }

    @GetMapping("/findManagerById")
    public ResponseEntity<Manager> findManagerById(@RequestParam Long managerId)
    {
        Manager manager = managerService.findManagerById(managerId);
        return new ResponseEntity<>(manager, HttpStatus.OK);
    }

    @PostMapping("/updateManagerNameAndLastName")
    public ResponseEntity<String> updateManagerNameAndLastName(@RequestBody UpdateManagerNameAndLastnameRequestDto updateManagerNameAndLastnameRequestDto)
    {
        String updateText = managerService.updateManagerNameAndLastnameById(updateManagerNameAndLastnameRequestDto);

        return new ResponseEntity<>(updateText, HttpStatus.OK);
    }

    @PostMapping("/updateManagerPhoneById")
    public ResponseEntity<String> updateManagerPhoneById(@RequestBody UpdateManagerPhoneRequestDto updateManagersPhoneRequestDto)
    {
        String updateText = managerService.updateManagerPhoneById(updateManagersPhoneRequestDto);

        return new ResponseEntity<>(updateText, HttpStatus.OK);
    }

}
