package com.firatyildiz.LanguageSchoolManagement.service;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.TeacherRequestDto.AddCourseToTeacherRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.TeacherRequestDto.SaveTeacherRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.TeacherRequestDto.UpdateTeacherRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.ResponseDto.TeacherResponseDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Course;
import com.firatyildiz.LanguageSchoolManagement.entity.Teacher;
import com.firatyildiz.LanguageSchoolManagement.repository.CourseRepository;
import com.firatyildiz.LanguageSchoolManagement.repository.TeacherRepository;
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
public class TeacherServiceImpl implements TeacherService {

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

    public String updateTeacherById (UpdateTeacherRequestDto updateTeacherRequestDto)
    {
        long updateTeacherRequestId = updateTeacherRequestDto.getId();

        Optional<Teacher> teacherOptional = teacherRepository.findById(updateTeacherRequestId);
        Teacher teacher = teacherOptional.get();

        teacher = modelMapper.map(updateTeacherRequestDto, Teacher.class);

        teacherRepository.save(teacher);

        return "Changes Saved.";
    }

    public String addCourseToTeacherById (AddCourseToTeacherRequestDto addCourseToTeacherRequestDto)
    {
        long teacherIdRequest = addCourseToTeacherRequestDto.getTeacherId();
        long courseIdRequest = addCourseToTeacherRequestDto.getCourseId();

        Teacher teacher = teacherRepository.findById(teacherIdRequest).get();
        Course course = courseRepository.findById(courseIdRequest).get();

        List<Course> courses = new ArrayList<>();
        courses.add(course);
        teacher.setCourses(courses);

        teacherRepository.save(teacher);

        return "Added Course";
    }

    public String deleteTeacherById (long teacherId)
    {
        Optional<Teacher> teacherOptional = teacherRepository.findById(teacherId);
        Teacher teacher = teacherOptional.get();
        teacherRepository.delete(teacher);

        return "The Teacher Deleted.";
    }

    public List<TeacherResponseDto> findAllTeacher ()
    {
        Iterable<Teacher> teachers = teacherRepository.findAll();

        List<TeacherResponseDto> teacherResponseDtos = new ArrayList<>();

        for (Teacher teacher : teachers)
        {
            TeacherResponseDto teacherResponseDto = modelMapper.map(teacher, TeacherResponseDto.class);
            teacherResponseDtos.add(teacherResponseDto);
        }

        return teacherResponseDtos;
    }


}
