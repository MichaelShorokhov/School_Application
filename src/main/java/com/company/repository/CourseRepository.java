package com.company.repository;

import com.company.entities.Course;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    @Transactional
    @Modifying
    @Query("delete from Course where id=:id")
    @Override
    void deleteById(@Param("id") Long id);
}
