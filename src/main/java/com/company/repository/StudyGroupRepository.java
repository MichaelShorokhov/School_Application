package com.company.repository;

import com.company.entities.StudyGroup;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudyGroupRepository extends CrudRepository<StudyGroup,Long> {
    @Transactional
    @Modifying
    @Query("delete from StudyGroup where id=:id")
    @Override
    void deleteById(@Param("id")Long id);
}
