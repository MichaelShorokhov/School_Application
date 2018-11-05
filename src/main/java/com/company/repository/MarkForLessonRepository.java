package com.company.repository;

import com.company.entities.MarkForLesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkForLessonRepository extends CrudRepository<MarkForLesson,Long> {
}
