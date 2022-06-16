package com.firatyildiz.LanguageSchoolManagement.controller;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ClassroomRequestDto.SaveClassroomRequestDto;
import com.firatyildiz.LanguageSchoolManagement.service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Classroom")
@RequiredArgsConstructor
public class ClassroomController {

    private final ClassroomService classroomService;

    @PostMapping("/saveClassroom")
    private ResponseEntity<String> saveClassroom(@RequestBody SaveClassroomRequestDto saveClassroomRequestDto)
    {
        String saveText = classroomService.saveClassroom(saveClassroomRequestDto);

        return new ResponseEntity<>(saveText, HttpStatus.OK);
    }

    


}
