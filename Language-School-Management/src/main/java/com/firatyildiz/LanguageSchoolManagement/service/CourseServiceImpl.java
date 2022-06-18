package com.firatyildiz.LanguageSchoolManagement.service;


import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.CourseRequestDto.SaveCourseRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.CourseRequestDto.SaveCourseWithoutStudentRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.CourseRequestDto.SaveStudentToCourseRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.CourseRequestDto.UpdateCourseRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.ResponseDto.CourseResponseDto;
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
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    private final StudentRepository studentRepository;

    private final ModelMapper modelMapper;

    private final Course course;


    public String saveCourse (SaveCourseRequestDto saveCourseResponseDto)
    {
        if (course.getCapacity() < 0)
        {
            return "Capacity is full";
        }
        else
        {
            Course course = modelMapper.map(saveCourseResponseDto, Course.class);

            course = courseRepository.save(course);

            return "Classroom Has Been Created.";
        }
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
        if (course.getCapacity() < 0)
        {
            return "Capacity is full.";
        }
        else
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

    public List<CourseResponseDto> findAllCourse ()
    {
        Iterable<Course> courses = courseRepository.findAll();

        List<CourseResponseDto> courseResponseDtos = new ArrayList<>();

        for (Course course : courses)
        {
            CourseResponseDto courseResponseDto = modelMapper.map(course, CourseResponseDto.class);
            courseResponseDtos.add(courseResponseDto);
        }

        return courseResponseDtos;
    }

}
