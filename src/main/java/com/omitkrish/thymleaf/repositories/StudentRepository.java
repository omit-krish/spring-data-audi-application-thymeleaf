package com.omitkrish.thymleaf.repositories;

import com.omitkrish.thymleaf.entities.StudentEnquiryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//optional
@Repository
public interface StudentRepository extends JpaRepository<StudentEnquiryEntity,Integer> {
}
