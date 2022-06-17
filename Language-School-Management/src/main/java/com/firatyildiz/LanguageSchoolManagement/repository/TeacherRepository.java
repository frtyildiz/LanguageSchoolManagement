package com.firatyildiz.LanguageSchoolManagement.repository;

import com.firatyildiz.LanguageSchoolManagement.entity.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository <Teacher, Long> {
}
