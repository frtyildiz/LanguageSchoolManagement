package com.firatyildiz.LanguageSchoolManagement.service;


import com.firatyildiz.LanguageSchoolManagement.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl {

    private final StudentRepository studentRepository;

    private final ModelMapper modelMapper;


}
