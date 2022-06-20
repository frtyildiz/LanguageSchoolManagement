package com.firatyildiz.LanguageSchoolManagement.service;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.CourseRequestDto.SaveCourseRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.CourseRequestDto.SaveCourseWithoutStudentRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.CourseRequestDto.SaveStudentToCourseRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.CourseRequestDto.UpdateCourseRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.ResponseDto.CourseResponseDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Course;

import java.util.List;

public interface CourseService {
    String saveCourse (SaveCourseRequestDto saveCourseResponseDto);

    String saveCourseWithoutStudent (SaveCourseWithoutStudentRequestDto saveCourseWithoutStudentRequestDto);

    Course findCourseById (long courseId);
    String addStudentToCourseByIds (SaveStudentToCourseRequestDto saveStudentToCourseRequestDto);

    String updateCourseById (UpdateCourseRequestDto updateCourseRequestDto);

    String deleteCourseById (long courseId);

    List<CourseResponseDto> findAllCourse ();
}
