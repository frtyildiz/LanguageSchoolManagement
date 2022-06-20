package com.firatyildiz.LanguageSchoolManagement.controller;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.TeacherRequestDto.AddCourseToTeacherRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.TeacherRequestDto.SaveTeacherRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.TeacherRequestDto.UpdateTeacherRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.ResponseDto.TeacherResponseDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Teacher;
import com.firatyildiz.LanguageSchoolManagement.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping("/saveTeacher")
    private ResponseEntity<String> saveTeacher(@RequestBody SaveTeacherRequestDto saveTeacherRequestDto)
    {
        String saveText = teacherService.saveTeacher(saveTeacherRequestDto);

        return new ResponseEntity<>(saveText, HttpStatus.OK);
    }

    @GetMapping("/findTeacher")
    public ResponseEntity<Teacher> findTeacherById (@RequestParam long teacherId)
    {
        Teacher teacher = teacherService.findTeacherById(teacherId);

        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @PostMapping("/updateTeacher")
    public ResponseEntity<String> updateTeacher (@RequestBody UpdateTeacherRequestDto updateTeacherRequestDto)
    {
        String updateText = teacherService.updateTeacherById(updateTeacherRequestDto);

        return new ResponseEntity<>(updateText, HttpStatus.OK);
    }

    @PostMapping("/addCourseToTeacher")
    public ResponseEntity<String> addCourseToTeacher (@RequestBody AddCourseToTeacherRequestDto addCourseToTeacherRequestDto)
    {
        String addCourseText = teacherService.addCourseToTeacherById(addCourseToTeacherRequestDto);

        return new ResponseEntity<>(addCourseText, HttpStatus.OK);
    }

    @DeleteMapping("/deleteTeacher")
    public ResponseEntity<String> deleteTeacher (@RequestParam long teacherId)
    {
        String deleteText = teacherService.deleteTeacherById(teacherId);

        return new ResponseEntity<>(deleteText, HttpStatus.OK);
    }

    @GetMapping("/findAllTeacher")
    public ResponseEntity<List<TeacherResponseDto>> findAllTeacher ()
    {
        List<TeacherResponseDto> teacherResponseDtos = teacherService.findAllTeacher();

        return new ResponseEntity<>(teacherResponseDtos, HttpStatus.OK);
    }
}
