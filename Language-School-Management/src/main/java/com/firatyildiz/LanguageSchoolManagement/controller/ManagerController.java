package com.firatyildiz.LanguageSchoolManagement.controller;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDto.SaveManagerRequestDto;
import com.firatyildiz.LanguageSchoolManagement.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
