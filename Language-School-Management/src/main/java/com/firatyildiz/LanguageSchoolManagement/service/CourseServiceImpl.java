package com.firatyildiz.LanguageSchoolManagement.service;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.CourseRequestDto.SaveCourseRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.CourseRequestDto.SaveCourseWithoutStudentRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.CourseRequestDto.SaveStudentToCourseRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.CourseRequestDto.UpdateCourseRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.ResponseDto.CourseResponseDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Classroom;
import com.firatyildiz.LanguageSchoolManagement.entity.Course;
import com.firatyildiz.LanguageSchoolManagement.entity.Student;
import com.firatyildiz.LanguageSchoolManagement.entity.Teacher;
import com.firatyildiz.LanguageSchoolManagement.repository.CourseRepository;
import com.firatyildiz.LanguageSchoolManagement.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    private final ModelMapper modelMapper;

    private final ClassroomService classroomService;

    private final TeacherService teacherService;

    private final StudentService studentService;

    private final StudentRepository studentRepository;

    public String saveCourse (SaveCourseRequestDto saveCourseRequestDto)
    {
        String courseNameRequest = saveCourseRequestDto.getCourseName();
        String courseLevelRequest = saveCourseRequestDto.getCourseLevel();
        LocalDate startDateRequest = saveCourseRequestDto.getStartDate();
        LocalDate endDateRequest = saveCourseRequestDto.getEndDate();
        long classroomIdRequest = saveCourseRequestDto.getClassroomId();
        long teacherIdRequest = saveCourseRequestDto.getTeacherId();
        long studentIdRequest = saveCourseRequestDto.getStudentId();

        Course course = new Course();
        Classroom classroom = classroomService.findClassroomById(classroomIdRequest);
        Teacher teacher = teacherService.findTeacherById(teacherIdRequest);
        Student student = studentService.findStudentById(studentIdRequest);

        course.setCourseName(courseNameRequest);
        course.setCourseLevel(courseLevelRequest);
        course.setStartDate(startDateRequest);
        course.setEndDate(endDateRequest);
        course.setClassroom(classroom);
        course.setTeacher(teacher);

        List<Student> students = new ArrayList<>();
        students.add(student);
        course.setStudents(students);

        List<Course> courses = new ArrayList<>();
        courses.add(course);
        student.setCourses(courses);

        courseRepository.save(course);

        return "Course Has Been Created.";
    }

    public String saveCourseWithoutStudent (SaveCourseWithoutStudentRequestDto saveCourseWithoutStudentRequestDto)
    {
        String courseNameRequest = saveCourseWithoutStudentRequestDto.getCourseName();
        String courseLevelRequest = saveCourseWithoutStudentRequestDto.getCourseLevel();
        LocalDate startDateRequest = saveCourseWithoutStudentRequestDto.getStartDate();
        LocalDate endDateRequest = saveCourseWithoutStudentRequestDto.getEndDate();
        long classroomIdRequest = saveCourseWithoutStudentRequestDto.getClassroomId();
        long teacherIdRequest = saveCourseWithoutStudentRequestDto.getTeacherId();

        Course course = new Course();
        Classroom classroom = classroomService.findClassroomById(classroomIdRequest);
        Teacher teacher = teacherService.findTeacherById(teacherIdRequest);

        course.setCourseName(courseNameRequest);
        course.setCourseLevel(courseLevelRequest);
        course.setStartDate(startDateRequest);
        course.setEndDate(endDateRequest);
        course.setClassroom(classroom);
        course.setTeacher(teacher);

        courseRepository.save(course);

        return "Course Has Been Created.";
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

        List<Course> courses = new ArrayList<>();
        courses.add(course);
        student.setCourses(courses);

        courseRepository.save(course);

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
