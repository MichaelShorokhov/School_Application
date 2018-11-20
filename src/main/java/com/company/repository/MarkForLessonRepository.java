package com.company.repository;

import com.company.entities.MarkForLesson;
import com.company.entities.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MarkForLessonRepository extends CrudRepository<MarkForLesson,Long> {
    @Transactional
    @Modifying
    @Query("delete from MarkForLesson where student= :student ")
    void deleteByStudent(@Param("student") Student student);
}
