package com.firatyildiz.LanguageSchoolManagement.service;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.StudentRequestDto.AddCourseToStudentById;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.StudentRequestDto.SaveStudentRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.StudentRequestDto.UpdateStudentRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.ResponseDto.StudentResponseDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Student;

import java.util.List;

public interface StudentService {

    String saveStudent (SaveStudentRequestDto saveStudentRequestDto);

    Student findStudentById (long studentId);

    String updateStudentById (UpdateStudentRequestDto updateStudentRequestDto);


    String addCourseToStudentById (AddCourseToStudentById addCourseToStudentById);


    String deleteStudentById (long studentId);


    List<StudentResponseDto> findAllStudent();

}
