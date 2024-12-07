package com.Hri.studentanalyticalproject.service;

import com.Hri.studentanalyticalproject.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
   Student saveStudent(Student student);
   List<Student> getAllStudents();
   Optional<Student> getStudentById(int id); // New method to fetch student by ID
}
