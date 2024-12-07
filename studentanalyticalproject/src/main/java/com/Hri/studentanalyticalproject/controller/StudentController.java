package com.Hri.studentanalyticalproject.controller;

import com.Hri.studentanalyticalproject.model.Student;
import com.Hri.studentanalyticalproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Add Student Endpoint
    @PostMapping("/add")
    public String add(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "New student added";
    }

    // Get All Students Endpoint
    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Update Attendance Status Endpoint
    @PutMapping("/markAttendance/{id}")
    public ResponseEntity<String> markAttendance(@PathVariable int id, @RequestParam String status) {
        try {
            Optional<Student> studentOptional = studentService.getStudentById(id);
            if (studentOptional.isPresent()) {
                Student student = studentOptional.get();
                student.setAttendanceStatus(status); // Set the attendance status (P or A)
                studentService.saveStudent(student); // Save the updated student entity
                return ResponseEntity.ok("Attendance updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    // Get Attendance Status for a Student by ID
    @GetMapping("/getAttendance/{id}")
    public ResponseEntity<String> getAttendance(@PathVariable int id) {
        try {
            Optional<Student> studentOptional = studentService.getStudentById(id);
            if (studentOptional.isPresent()) {
                Student student = studentOptional.get();
                return ResponseEntity.ok("Attendance Status: " + student.getAttendanceStatus());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
}
