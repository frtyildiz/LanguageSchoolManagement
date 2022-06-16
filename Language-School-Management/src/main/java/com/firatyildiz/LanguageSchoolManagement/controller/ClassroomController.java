package com.firatyildiz.LanguageSchoolManagement.controller;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ClassroomRequestDto.AddCourseToClassroomRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ClassroomRequestDto.SaveClassroomRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ClassroomRequestDto.UpdateClassroomRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.ResponseDto.ClassroomResponseDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Classroom;
import com.firatyildiz.LanguageSchoolManagement.service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/findClassroom")
    public ResponseEntity<Classroom> findClassroomById (@RequestParam long classroomId)
    {
        Classroom classroom = classroomService.findClassroomById(classroomId);

        return new ResponseEntity<>(classroom, HttpStatus.OK);
    }

    @PostMapping("/updateClassroom")
    public ResponseEntity<String> updateClassroom (@RequestBody UpdateClassroomRequestDto updateClassroomRequestDto)
    {
        String updateText = classroomService.updateClassroom(updateClassroomRequestDto);

        return new ResponseEntity<>(updateText, HttpStatus.OK);
    }

    @PostMapping("/addCourseToClassroom")
    public ResponseEntity<String> addCourseToClassroom (@RequestBody AddCourseToClassroomRequestDto addCourseToClassroomRequestDto)
    {
        String addCourseText = classroomService.addCourseToClassroomById(addCourseToClassroomRequestDto);

        return new ResponseEntity<>(addCourseText, HttpStatus.OK);
    }

    @DeleteMapping("/deleteClassroom")
    public ResponseEntity<String> deleteClassroom (@RequestParam long classroomId)
    {
        String deleteText = classroomService.deleteClassroomById(classroomId);

        return new ResponseEntity<>(deleteText, HttpStatus.OK);
    }

    @GetMapping("/findAllClassroom")
    public ResponseEntity<List<ClassroomResponseDto>> findAllCourse ()
    {
        List<ClassroomResponseDto> classroomResponseDtos = classroomService.findAllClassroom();

        return new ResponseEntity<>(classroomResponseDtos, HttpStatus.OK);
    }


}
