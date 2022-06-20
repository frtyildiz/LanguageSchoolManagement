package com.firatyildiz.LanguageSchoolManagement.service;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.TeacherRequestDto.SaveTeacherRequestDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Teacher;
import com.firatyildiz.LanguageSchoolManagement.repository.CourseRepository;
import com.firatyildiz.LanguageSchoolManagement.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

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
        teacherMock.setName("test");
        teacherMock.setLastname("test");
        teacherMock.setMajor("test");
        teacherMock.setSalary(12300);

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

    }

    @Test
    void testUpdateTeacherById()
    {
    }

    @Test
    void testAddCourseToTeacherById()
    {
    }

    @Test
    void testDeleteTeacherById()
    {
    }
}