package com.firatyildiz.LanguageSchoolManagement.service;

import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ClassroomRequestDto.AddCourseToClassroomRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ClassroomRequestDto.SaveClassroomRequestDto;
import com.firatyildiz.LanguageSchoolManagement.dtos.RequestDtos.ClassroomRequestDto.UpdateClassroomRequestDto;
import com.firatyildiz.LanguageSchoolManagement.entity.Classroom;
import com.firatyildiz.LanguageSchoolManagement.entity.Course;
import com.firatyildiz.LanguageSchoolManagement.repository.ClassroomRepository;
import com.firatyildiz.LanguageSchoolManagement.repository.CourseRepository;
import org.junit.jupiter.api.AfterEach;
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
class ClassroomServiceImplTest {

    @InjectMocks
    ClassroomServiceImpl classroomService;

    @Mock
    ClassroomRepository classroomRepository;

    @Mock
    CourseRepository courseRepository;

    @Mock
    ModelMapper modelMapper;

    @Test
    void testSaveClassroom()
    {
        SaveClassroomRequestDto saveClassroomRequestDtoMock = mock(SaveClassroomRequestDto.class);
        saveClassroomRequestDtoMock.setClassroomName("testName");
        saveClassroomRequestDtoMock.setCapacity((byte) 12);

        Classroom classroomMock = mock(Classroom.class);
        classroomMock.setId(1);

        when(modelMapper.map(saveClassroomRequestDtoMock, Classroom.class)).thenReturn(classroomMock);
        when(classroomRepository.save(classroomMock)).thenReturn(classroomMock);

        String saveClassroom = classroomService.saveClassroom(saveClassroomRequestDtoMock);
        String saveClassroomMessage = "Classroom Has Been Created.";

        assertEquals(saveClassroomMessage, saveClassroom);
    }

    @Test
    void TestfindClassroomById()
    {
        Classroom classroomMock = mock(Classroom.class);
        classroomMock.setId(1);

        when(classroomRepository.findById(classroomMock.getId())).thenReturn(Optional.of(classroomMock));
        Classroom findClassroom = classroomService.findClassroomById(classroomMock.getId());

        assertEquals(classroomMock, findClassroom);
    }

    @Test
    void TestAddCourseToClassroomById()
    {
        AddCourseToClassroomRequestDto addCourseToClassroomRequestDtoMock = mock(AddCourseToClassroomRequestDto.class);
        addCourseToClassroomRequestDtoMock.setClassroomId(1);
        addCourseToClassroomRequestDtoMock.setCourseId(1);

        Classroom classroomMock = mock(Classroom.class);
        Course courseMock = mock(Course.class);

        when(classroomRepository.findById(addCourseToClassroomRequestDtoMock.getClassroomId())).thenReturn(Optional.of(classroomMock));
        when(courseRepository.findById(addCourseToClassroomRequestDtoMock.getCourseId())).thenReturn(Optional.of(courseMock));

        List<Course> courses = new ArrayList<>();
        courses.add(courseMock);
        classroomMock.setCourses(courses);

        when(classroomRepository.save(classroomMock)).thenReturn(classroomMock);

        String addCourseToClassroom = classroomService.addCourseToClassroomById(addCourseToClassroomRequestDtoMock);
        String addCourseToClassroomMessage = "Added Course The Classroom";

        assertEquals(addCourseToClassroomMessage, addCourseToClassroom);
    }

    @Test
    void testUpdateClassroom()
    {
        Classroom classroomMock = mock(Classroom.class);
        classroomMock.setId(1);
        classroomMock.setClassroomName("testName");
        classroomMock.setCapacity((byte) 12);

        UpdateClassroomRequestDto updateClassroomRequestDtoMock = mock(UpdateClassroomRequestDto.class);
        updateClassroomRequestDtoMock.setClassroomName("testUpdate");
        updateClassroomRequestDtoMock.setCapacity((byte) 1);

        when(classroomRepository.findById(classroomMock.getId())).thenReturn(Optional.of(classroomMock));
        when(modelMapper.map(updateClassroomRequestDtoMock, Classroom.class)).thenReturn(classroomMock);
        when(classroomRepository.save(classroomMock)).thenReturn(classroomMock);

        String updateClassroom = classroomService.updateClassroom(updateClassroomRequestDtoMock);
        String updateClassroomMessage = "Changes Saved.";

        assertEquals(updateClassroomMessage, updateClassroom);
    }

    @Test
    void testDeleteClassroomById()
    {
        Classroom classroomMock = mock(Classroom.class);
        classroomMock.setId(1);

        when(classroomRepository.findById(classroomMock.getId())).thenReturn(Optional.of(classroomMock));
        String deleteClassroom = classroomService.deleteClassroomById(classroomMock.getId());
        String deleteClassroomMessage = "The Manager Deleted.";

        assertEquals(deleteClassroomMessage, deleteClassroom);
    }
}