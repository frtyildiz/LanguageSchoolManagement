package com.firatyildiz.LanguageSchoolManagement.service;

import com.firatyildiz.LanguageSchoolManagement.repository.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClassroomServiceImpl {

    private final ClassroomRepository classroomRepository;

    private final ModelMapper modelMapper;

    @Transactional
    public String saveClassroom ()

}
