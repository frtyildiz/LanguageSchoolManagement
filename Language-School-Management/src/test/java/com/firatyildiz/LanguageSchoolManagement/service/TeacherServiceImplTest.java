package com.firatyildiz.LanguageSchoolManagement.service;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.TeacherRequestDto.AddCourseToTeacherRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.TeacherRequestDto.SaveTeacherRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.TeacherRequestDto.UpdateTeacherRequestDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Course;
import com.firatyildiz.LanguageSchoolManagement.entity.Teacher;
import com.firatyildiz.LanguageSchoolManagement.repository.CourseRepository;
import com.firatyildiz.LanguageSchoolManagement.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TeacherServiceImplTest {

    @InjectMocks
    TeacherServiceImpl teacherService;

    @Mock
    TeacherRepository teacherRepository;

    @Mock
    CourseRepository courseRepository;

    @Mock
    ModelMapper modelMapper;

    @Test
    void testSaveTeacher()
    {
        Teacher teacherMock = mock(Teacher.class);
        teacherMock.setId(1);

        SaveTeacherRequestDto saveTeacherRequestDtoMock = mock(SaveTeacherRequestDto.class);
        saveTeacherRequestDtoMock.setName("testName");
        saveTeacherRequestDtoMock.setLastname("testLastname");

        when(modelMapper.map(saveTeacherRequestDtoMock, Teacher.class)).thenReturn(teacherMock);
        when(teacherRepository.save(teacherMock)).thenReturn(teacherMock);

        String saveTeacher = teacherService.saveTeacher(saveTeacherRequestDtoMock);
        String saveTeacherMessage = "Teacher Has Been Created.";

        assertEquals(saveTeacherMessage, saveTeacher);
    }

    @Test
    void testFindTeacherById()
    {
        Teacher teacherMock = mock(Teacher.class);
        teacherMock.setId(1);
        teacherMock.setName("test");
        teacherMock.setLastname("test");
        teacherMock.setMajor("test");
        teacherMock.setSalary(12300);

        when(teacherRepository.findById(teacherMock.getId())).thenReturn(Optional.of(teacherMock));
        Teacher findTeacher = teacherService.findTeacherById(teacherMock.getId());

        assertEquals(teacherMock, findTeacher);
    }

    @Test
    void testUpdateTeacherById()
    {
        Teacher teacherMock = mock(Teacher.class);
        teacherMock.setId(1);
        teacherMock.setName("test");
        teacherMock.setLastname("test");
        teacherMock.setMajor("test");
        teacherMock.setSalary(12300);

        UpdateTeacherRequestDto updateTeacherRequestDtoMock = mock(UpdateTeacherRequestDto.class);
        updateTeacherRequestDtoMock.setId(1);
        updateTeacherRequestDtoMock.setName("testName");
        updateTeacherRequestDtoMock.setLastname("testLastname");

        when(teacherRepository.findById(updateTeacherRequestDtoMock.getId())).thenReturn(Optional.of(teacherMock));
        when(modelMapper.map(updateTeacherRequestDtoMock, Teacher.class)).thenReturn(teacherMock);
        when(teacherRepository.save(teacherMock)).thenReturn(teacherMock);

        String updateTeacher = teacherService.updateTeacherById(updateTeacherRequestDtoMock);
        String updateTeacherMessage = "Changes Saved.";

        assertEquals(updateTeacherMessage, updateTeacher);
    }

    @Test
    void testAddCourseToTeacherById()
    {
        Teacher teacherMock = mock(Teacher.class);
        teacherMock.setId(1);
        teacherMock.setName("test");
        teacherMock.setLastname("test");
        teacherMock.setMajor("test");
        teacherMock.setSalary(12300);

        Course courseMock = mock(Course.class);
        courseMock.setId(1);

        AddCourseToTeacherRequestDto addCourseToTeacherRequestDto = mock(AddCourseToTeacherRequestDto.class);
        addCourseToTeacherRequestDto.setTeacherId(1);
        addCourseToTeacherRequestDto.setCourseId(1);

        when(teacherRepository.findById(addCourseToTeacherRequestDto.getTeacherId())).thenReturn(Optional.of(teacherMock));
        when(courseRepository.findById(addCourseToTeacherRequestDto.getCourseId())).thenReturn(Optional.of(courseMock));

        List<Course> courses = new ArrayList<>();
        courses.add(courseMock);
        teacherMock.setCourses(courses);

        when(teacherRepository.save(teacherMock)).thenReturn(teacherMock);

        String addCourseToTeacher = teacherService.addCourseToTeacherById(addCourseToTeacherRequestDto);
        String addCourseToTeacherMessage = "Added Course";

        assertEquals(addCourseToTeacherMessage, addCourseToTeacher);
    }

    @Test
    void testDeleteTeacherById()
    {
        Teacher teacherMock = mock(Teacher.class);
        teacherMock.setId(1);
        teacherMock.setName("test");
        teacherMock.setLastname("test");
        teacherMock.setMajor("test");
        teacherMock.setSalary(12300);

        when(teacherRepository.findById(teacherMock.getId())).thenReturn(Optional.of(teacherMock));
        String deleteStudent = teacherService.deleteTeacherById(teacherMock.getId());
        String deleteStudentMessage = "The Teacher Deleted.";

        assertEquals(deleteStudentMessage, deleteStudent);
    }
}