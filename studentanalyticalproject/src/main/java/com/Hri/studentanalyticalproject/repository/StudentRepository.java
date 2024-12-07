package com.Hri.studentanalyticalproject.repository;

import com.Hri.studentanalyticalproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // JpaRepository already has the necessary methods for CRUD operations
}
