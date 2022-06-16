package com.firatyildiz.LanguageSchoolManagement.repository;

import com.firatyildiz.LanguageSchoolManagement.entity.Classroom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends CrudRepository <Classroom, Long> {
}
