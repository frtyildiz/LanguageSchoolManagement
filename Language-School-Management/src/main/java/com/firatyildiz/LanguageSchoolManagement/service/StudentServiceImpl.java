package com.firatyildiz.LanguageSchoolManagement.service;


import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.StudentRequestDto.AddCourseToStudentById;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.StudentRequestDto.SaveStudentRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.StudentRequestDto.UpdateStudentRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.ResponseDto.StudentResponseDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Course;
import com.firatyildiz.LanguageSchoolManagement.entity.Student;
import com.firatyildiz.LanguageSchoolManagement.repository.CourseRepository;
import com.firatyildiz.LanguageSchoolManagement.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

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

    public String updateStudentById (UpdateStudentRequestDto updateStudentRequestDto)
    {
        long updateStudentRequestId = updateStudentRequestDto.getId();

        Optional<Student> studentOptional = studentRepository.findById(updateStudentRequestId);
        Student student = studentOptional.get();

        student = modelMapper.map(updateStudentRequestDto, Student.class);

        studentRepository.save(student);

        return "Changes Saved.";
    }

    public String addCourseToStudentById (AddCourseToStudentById addCourseToStudentById)
    {
        long studentId = addCourseToStudentById.getStudentId();
        long courseId = addCourseToStudentById.getCourseId();

        Student student = studentRepository.findById(studentId).get();
        Course course = courseRepository.findById(courseId).get();

        List<Course> courses = new ArrayList<>();
        courses.add(course);

        student.setCourses(courses);

        studentRepository.save(student);

        return "Added Course";

    }

    public String deleteStudentById (long studentId)
    {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Student student = studentOptional.get();
        studentRepository.delete(student);

        return "The Student Deleted.";
    }

    public List<StudentResponseDto> findAllStudent ()
    {
        Iterable<Student> students = studentRepository.findAll();

        List<StudentResponseDto> studentResponseDtos = new ArrayList<>();

        for (Student student : students)
        {
            StudentResponseDto studentResponseDto = modelMapper.map(student, StudentResponseDto.class);
            studentResponseDtos.add(studentResponseDto);
        }

        return studentResponseDtos;
    }

}
