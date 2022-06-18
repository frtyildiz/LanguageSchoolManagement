package com.firatyildiz.LanguageSchoolManagement.service;


import com.firatyildiz.LanguageSchoolManagement.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CourseServiceImpl {

    private final CourseRepository courseRepository;

    private final ModelMapper modelMapper;

    public String saveCourse ()

}
