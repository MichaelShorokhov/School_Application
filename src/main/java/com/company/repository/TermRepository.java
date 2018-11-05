package com.company.repository;

import com.company.entities.Term;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermRepository extends CrudRepository<Term,Long>{
}
