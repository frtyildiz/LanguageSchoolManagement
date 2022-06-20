package com.firatyildiz.LanguageSchoolManagement.service;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.StudentRequestDto.AddCourseToStudentRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.StudentRequestDto.SaveStudentRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.StudentRequestDto.UpdateStudentRequestDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Course;
import com.firatyildiz.LanguageSchoolManagement.entity.Student;
import com.firatyildiz.LanguageSchoolManagement.repository.CourseRepository;
import com.firatyildiz.LanguageSchoolManagement.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @InjectMocks
    StudentServiceImpl studentService;

    @Mock
    StudentRepository studentRepository;

    @Mock
    CourseRepository courseRepository;

    @Mock
    ModelMapper modelMapper;

    @Test
    void testSaveStudent()
    {
        Student studentMock = mock(Student.class);
        studentMock.setId(1);

        SaveStudentRequestDto saveStudentRequestDtoMock = mock(SaveStudentRequestDto.class);
        saveStudentRequestDtoMock.setName("testName");
        saveStudentRequestDtoMock.setLastname("testLastname");

        when(modelMapper.map(saveStudentRequestDtoMock, Student.class)).thenReturn(studentMock);
        when(studentRepository.save(studentMock)).thenReturn(studentMock);

        String saveStudent = studentService.saveStudent(saveStudentRequestDtoMock);
        String saveStudentMessage = "Student Has Been Created.";

        assertEquals(saveStudentMessage, saveStudent);
    }

    @Test
    void testFindStudentById()
    {
        Student studentMock = mock(Student.class);
        studentMock.setId(1);
        studentMock.setIdentityCardNo(123);
        studentMock.setName("test");
        studentMock.setLastname("test");

        when(studentRepository.findById(studentMock.getId())).thenReturn(Optional.of(studentMock));
        Student findStudent = studentService.findStudentById(studentMock.getId());

        assertEquals(studentMock, findStudent);
    }

    @Test
    void testUpdateStudentById()
    {
        Student studentMock = mock(Student.class);
        studentMock.setId(1);
        studentMock.setIdentityCardNo(123);
        studentMock.setName("test");
        studentMock.setLastname("test");

        UpdateStudentRequestDto updateStudentRequestDtoMock = mock(UpdateStudentRequestDto.class);
        updateStudentRequestDtoMock.setId(studentMock.getId());
        updateStudentRequestDtoMock.setName("testName");
        updateStudentRequestDtoMock.setLastname("testLastname");

        when(studentRepository.findById(studentMock.getId())).thenReturn(Optional.of(studentMock));
        when(modelMapper.map(updateStudentRequestDtoMock, Student.class)).thenReturn(studentMock);
        when(studentRepository.save(studentMock)).thenReturn(studentMock);

        String updateStudent = studentService.updateStudentById(updateStudentRequestDtoMock);
        String updateStudentMessage = "Changes Saved.";

        assertEquals(updateStudentMessage, updateStudent);
    }

    @Test
    void testAddCourseToStudentById()
    {
        Student studentMock = mock(Student.class);
        studentMock.setId(1);
        studentMock.setIdentityCardNo(123);
        studentMock.setName("test");
        studentMock.setLastname("test");

        Course courseMock = mock(Course.class);
        courseMock.setId(1);

        AddCourseToStudentRequestDto addCourseToStudentRequestDtoMock = mock(AddCourseToStudentRequestDto.class);
        addCourseToStudentRequestDtoMock.setCourseId(1);
        addCourseToStudentRequestDtoMock.setStudentId(1);

        when(studentRepository.findById(addCourseToStudentRequestDtoMock.getStudentId())).thenReturn(Optional.of(studentMock));
        when(courseRepository.findById(addCourseToStudentRequestDtoMock.getCourseId())).thenReturn(Optional.of(courseMock));

        List<Course> courses = new ArrayList<>();
        courses.add(courseMock);
        studentMock.setCourses(courses);

        when(studentRepository.save(studentMock)).thenReturn(studentMock);

        String addCourseToStudent = studentService.addCourseToStudentById(addCourseToStudentRequestDtoMock);
        String addCourseToStudentMessage = "Added Course";

        assertEquals(addCourseToStudentMessage, addCourseToStudent);
    }

    @Test
    void testDeleteStudentById()
    {
        Student studentMock = mock(Student.class);
        studentMock.setId(1);
        studentMock.setIdentityCardNo(123);
        studentMock.setName("test");
        studentMock.setLastname("test");

        when(studentRepository.findById(studentMock.getId())).thenReturn(Optional.of(studentMock));
        String deleteStudent = studentService.deleteStudentById(studentMock.getId());
        String deleteStudentMessage = "The Student Deleted.";

        assertEquals(deleteStudentMessage, deleteStudent);
    }
}