package com.firatyildiz.LanguageSchoolManagement.service;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ClassroomRequestDto.AddCourseToClassroomRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ClassroomRequestDto.SaveClassroomRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ClassroomRequestDto.UpdateClassroomRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.ResponseDto.ClassroomResponseDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Classroom;

import java.util.List;

public interface ClassroomService {

    String saveClassroom (SaveClassroomRequestDto saveClassroomRequestDto);

    Classroom findClassroomById (long classroomId);

    String addCourseToClassroomById (AddCourseToClassroomRequestDto addCourseToClassroomRequestDto);

    String updateClassroom (UpdateClassroomRequestDto updateClassroomRequestDto);

    String deleteClassroomById (long classroomId);

    List<ClassroomResponseDto> findAllClassroom();
}