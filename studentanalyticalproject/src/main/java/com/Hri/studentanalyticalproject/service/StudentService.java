package com.Hri.studentanalyticalproject.service;

import com.Hri.studentanalyticalproject.model.Student;

import java.util.List;

public interface StudentService {
   public Student saveStudent(Student student);
   public List<Student> getAllStudents();
}
