package com.firatyildiz.LanguageSchoolManagement.repository;

import com.firatyildiz.LanguageSchoolManagement.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository <Course, Long> {
}
