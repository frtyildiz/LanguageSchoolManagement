package com.firatyildiz.LanguageSchoolManagement.service;


import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.StudentRequestDto.SaveStudentRequestDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Student;
import com.firatyildiz.LanguageSchoolManagement.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl {

    private final StudentRepository studentRepository;

    private final ModelMapper modelMapper;

    public String saveStudent (SaveStudentRequestDto saveStudentRequestDto)
    {
        Student student = modelMapper.map(saveStudentRequestDto, Student.class);

        student = studentRepository.save(student);

        return "Student Has Been Created.";
    }

    public Student findStudentById (long studentId)
    {
        return studentRepository.findById(studentId).get();
    }

    public String updateStudentById


}
