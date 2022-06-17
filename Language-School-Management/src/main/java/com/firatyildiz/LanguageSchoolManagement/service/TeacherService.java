package com.firatyildiz.LanguageSchoolManagement.service;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.TeacherRequestDto.AddCourseToTeacherRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.TeacherRequestDto.SaveTeacherRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.TeacherRequestDto.UpdateTeacherRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.ResponseDto.TeacherResponseDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Teacher;

import java.util.List;

public interface TeacherService {

    String saveTeacher (SaveTeacherRequestDto saveTeacherRequestDto);


    Teacher findTeacherById (long teacherId);


    String updateTeacherById (UpdateTeacherRequestDto updateTeacherRequestDto);


    String addCourseToTeacherById (AddCourseToTeacherRequestDto addCourseToTeacherRequestDto);


    String deleteTeacherById (long teacherId);


    List<TeacherResponseDto> findAllTeacher ();

}
