package com.firatyildiz.LanguageSchoolManagement.repository;

import com.firatyildiz.LanguageSchoolManagement.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository <Student, Long> {
}
