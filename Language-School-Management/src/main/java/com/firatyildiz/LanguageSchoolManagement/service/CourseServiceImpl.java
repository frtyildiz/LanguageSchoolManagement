package com.firatyildiz.LanguageSchoolManagement.service;


import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.CourseRequestDto.SaveCourseRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.CourseRequestDto.SaveCourseWithoutStudentRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.CourseRequestDto.SaveStudentToCourseRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.CourseRequestDto.UpdateCourseRequestDto;
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
public class CourseServiceImpl {

    private final CourseRepository courseRepository;

    private final StudentRepository studentRepository;

    private final ModelMapper modelMapper;


    public String saveCourse (SaveCourseRequestDto saveCourseResponseDto)
    {
        Course course = modelMapper.map(saveCourseResponseDto, Course.class);

        course = courseRepository.save(course);

        return "Classroom Has Been Created.";
    }

    public String saveCourseWithoutStudent (SaveCourseWithoutStudentRequestDto saveCourseWithoutStudentRequestDto)
    {
        Course course = modelMapper.map(saveCourseWithoutStudentRequestDto, Course.class);

        course = courseRepository.save(course);

        return "Classroom Has Been Created.";
    }

    public Course findCourseById (long courseId)
    {
        return courseRepository.findById(courseId).get();
    }

    public String addStudentToCourseByIds (SaveStudentToCourseRequestDto saveStudentToCourseRequestDto)
    {
        long courseId = saveStudentToCourseRequestDto.getCourseId();
        long studentId = saveStudentToCourseRequestDto.getStudentId();

        Course course = courseRepository.findById(courseId).get();
        Student student = studentRepository.findById(studentId).get();

        List<Student> students = new ArrayList<>();
        students.add(student);

        course.setStudents(students);

        return "Added Student";
    }

    public String updateCourseById (UpdateCourseRequestDto updateCourseRequestDto)
    {
        long updateCourseRequestId = updateCourseRequestDto.getId();

        Optional<Course> optionalCourse = courseRepository.findById(updateCourseRequestId);
        Course course = optionalCourse.get();

        course = modelMapper.map(updateCourseRequestDto, Course.class);

        courseRepository.save(course);
        return "Changes Saved.";
    }

    public String deleteCourseById (long courseId)
    {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        Course course = optionalCourse.get();

        courseRepository.delete(course);

        return "The Course Deleted.";
    }

    public List<>

}
