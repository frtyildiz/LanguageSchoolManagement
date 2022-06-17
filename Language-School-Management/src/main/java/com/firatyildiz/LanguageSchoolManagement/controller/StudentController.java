package com.firatyildiz.LanguageSchoolManagement.controller;


import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.StudentRequestDto.AddCourseToStudentRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.StudentRequestDto.SaveStudentRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.StudentRequestDto.UpdateStudentRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.ResponseDto.StudentResponseDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Student;
import com.firatyildiz.LanguageSchoolManagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Manager")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/saveStudent")
    private ResponseEntity<String> saveStudent(@RequestBody SaveStudentRequestDto saveStudentRequestDto)
    {
        String saveText = studentService.saveStudent(saveStudentRequestDto);

        return new ResponseEntity<>(saveText, HttpStatus.OK);
    }

    @GetMapping("/findStudent")
    public ResponseEntity<Student> findStudentById (@RequestParam long studentId)
    {
        Student student = studentService.findStudentById(studentId);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/updateStudent")
    public ResponseEntity<String> updateStudent (@RequestBody UpdateStudentRequestDto updateStudentRequestDto)
    {
        String updateText = studentService.updateStudentById(updateStudentRequestDto);

        return new ResponseEntity<>(updateText, HttpStatus.OK);
    }

    @PostMapping("/addCourseToStudent")
    public ResponseEntity<String> addCourseToStudent (@RequestBody AddCourseToStudentRequestDto addCourseToStudentRequestDto)
    {
        String addCourseText = studentService.addCourseToStudentById(addCourseToStudentRequestDto);

        return new ResponseEntity<>(addCourseText, HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent")
    public ResponseEntity<String> deleteStudent (@RequestParam long studentId)
    {
        String deleteText = studentService.deleteStudentById(studentId);

        return new ResponseEntity<>(deleteText, HttpStatus.OK);
    }

    @GetMapping("/findAllStudent")
    public ResponseEntity<List<StudentResponseDto>> findAllStudent ()
    {
        List<StudentResponseDto> studentResponseDtos = studentService.findAllStudent();

        return new ResponseEntity<>(studentResponseDtos, HttpStatus.OK);
    }


}
