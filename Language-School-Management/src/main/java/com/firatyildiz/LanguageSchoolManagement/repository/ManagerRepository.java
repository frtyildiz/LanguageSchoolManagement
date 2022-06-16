package com.firatyildiz.LanguageSchoolManagement.repository;

import com.firatyildiz.LanguageSchoolManagement.entity.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends CrudRepository <Manager, Long> {
}
