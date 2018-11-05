package com.company.repository;

import com.company.entities.StudyGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyGroupRepository extends CrudRepository<StudyGroup,Long> {
}
