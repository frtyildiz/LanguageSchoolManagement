package com.firatyildiz.LanguageSchoolManagement.service;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.TeacherRequestDto.SaveTeacherRequestDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Teacher;
import com.firatyildiz.LanguageSchoolManagement.repository.CourseRepository;
import com.firatyildiz.LanguageSchoolManagement.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TeacherServiceImpl {

    private final TeacherRepository teacherRepository;

    private final CourseRepository courseRepository;

    private final ModelMapper modelMapper;

    public String saveTeacher (SaveTeacherRequestDto saveTeacherRequestDto)
    {
        Teacher teacher = modelMapper.map(saveTeacherRequestDto, Teacher.class);

        teacher = teacherRepository.save(teacher);

        return "Teacher Has Been Created.";
    }

    public Teacher findTeacherById (long teacherId)
    {
        return teacherRepository.findById(teacherId).get();
    }

    public String updateTeacherById ()




}
