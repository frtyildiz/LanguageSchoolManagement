package com.firatyildiz.LanguageSchoolManagement.controller;


import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.CourseRequestDto.SaveCourseRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.CourseRequestDto.SaveCourseWithoutStudentRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.CourseRequestDto.SaveStudentToCourseRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.CourseRequestDto.UpdateCourseRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.ResponseDto.CourseResponseDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Course;
import com.firatyildiz.LanguageSchoolManagement.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/saveCourse")
    public ResponseEntity<String> saveCourse (@RequestBody SaveCourseRequestDto saveCourseRequestDto)
    {
        String saveText = courseService.saveCourse(saveCourseRequestDto);

        return new ResponseEntity<>(saveText, HttpStatus.OK);
    }

    @PostMapping("/saveCourseWithoutStudent")
    public ResponseEntity<String> saveCourseWithoutStudent (@RequestBody SaveCourseWithoutStudentRequestDto saveCourseWithoutStudentRequestDto)
    {
        String saveText = courseService.saveCourseWithoutStudent(saveCourseWithoutStudentRequestDto);

        return new ResponseEntity<>(saveText, HttpStatus.OK);
    }

    @GetMapping("/findCourses")
    public ResponseEntity<Course> findCourseById (@RequestParam long courseId)
    {
        Course course = courseService.findCourseById(courseId);

        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping("/updateCourse")
    public ResponseEntity<String> updateCourse (@RequestBody UpdateCourseRequestDto updateCourseRequestDto)
    {
        String updateText = courseService.updateCourseById(updateCourseRequestDto);

        return new ResponseEntity<>(updateText, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCourse")
    public ResponseEntity<String> deleteCourse (@RequestParam long courseId)
    {
        String deleteText = courseService.deleteCourseById(courseId);

        return new ResponseEntity<>(deleteText, HttpStatus.OK);
    }

    @PostMapping("/saveStudentToCourse")
    public ResponseEntity<String> saveStudentToCourse (@RequestBody SaveStudentToCourseRequestDto studentToCourseRequestDto)
    {
        String saveStudentToCourseText = courseService.addStudentToCourseByIds(studentToCourseRequestDto);

        return new ResponseEntity<>(saveStudentToCourseText, HttpStatus.OK);
    }

    @GetMapping("/findAllCourse")
    private ResponseEntity<List<CourseResponseDto>> findAllCourse ()
    {
        List<CourseResponseDto> courseResponseDtos = courseService.findAllCourse();

        return new ResponseEntity<>(courseResponseDtos, HttpStatus.OK);
    }

}
