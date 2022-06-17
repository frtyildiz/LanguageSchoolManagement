package com.firatyildiz.LanguageSchoolManagement.service;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ClassroomRequestDto.AddCourseToClassroomRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ClassroomRequestDto.SaveClassroomRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ClassroomRequestDto.UpdateClassroomRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.ResponseDto.ClassroomResponseDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Classroom;
import com.firatyildiz.LanguageSchoolManagement.entity.Course;
import com.firatyildiz.LanguageSchoolManagement.repository.ClassroomRepository;
import com.firatyildiz.LanguageSchoolManagement.repository.CourseRepository;
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
public class ClassroomServiceImpl implements ClassroomService{

    private final ClassroomRepository classroomRepository;

    private final CourseRepository courseRepository;

    private final ModelMapper modelMapper;

    public String saveClassroom (SaveClassroomRequestDto saveClassroomRequestDto)
    {
        Classroom classroom = modelMapper.map(saveClassroomRequestDto, Classroom.class);

        classroom = classroomRepository.save(classroom);

        return "Classroom Has Been Created.";
    }

    public Classroom findClassroomById (long classroomId)
    {
        return classroomRepository.findById(classroomId).get();
    }

    public String addCourseToClassroomById (AddCourseToClassroomRequestDto addCourseToClassroomRequestDto)
    {
        long classroomId = addCourseToClassroomRequestDto.getClassroomId();
        long courseId = addCourseToClassroomRequestDto.getCourseId();

        Classroom classroom = classroomRepository.findById(classroomId).get();
        Course course = courseRepository.findById(courseId).get();

        List<Course> courses = new ArrayList<>();
        courses.add(course);

        classroom.setCourses(courses);

        classroomRepository.save(classroom);

        return "Added Course The Classroom";
    }

    public String updateClassroom (UpdateClassroomRequestDto updateClassroomRequestDto)
    {
        long updateClassroomRequestId = updateClassroomRequestDto.getId();
        Optional<Classroom> optionalClassroom = classroomRepository.findById(updateClassroomRequestId);
        Classroom classroom = optionalClassroom.get();

        classroom = modelMapper.map(updateClassroomRequestDto, Classroom.class);

        classroomRepository.save(classroom);

        return "Changes Saved.";
    }


    public String deleteClassroomById (long classroomId)
    {
        Optional<Classroom> classroomOptional = classroomRepository.findById(classroomId);
        Classroom classroom = classroomOptional.get();
        classroomRepository.delete(classroom);

        return "The Manager Deleted.";
    }

    public List<ClassroomResponseDto> findAllClassroom()
    {
        Iterable<Classroom> classrooms = classroomRepository.findAll();

        List<ClassroomResponseDto> classroomResponseDtos = new ArrayList<>();

        for (Classroom classroom : classrooms)
        {
            ClassroomResponseDto classroomResponseDto = modelMapper.map(classroom, ClassroomResponseDto.class);
            classroomResponseDtos.add(classroomResponseDto);
        }

        return classroomResponseDtos;
    }

}
