package com.company.repository;

import com.company.entities.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher,Long> {

}
