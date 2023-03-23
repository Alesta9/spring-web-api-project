package com.example.MyProject.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// API/CONTROLLER LAYER HTTP
// CONNECTS WITH SERVICE LAYER
@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService; // DI with Constructor
    }

    @GetMapping(path = "/")
    public List<Student> getStudents() {
        return studentService.getStudents(); // Using StudentService's method. Thats business Logic
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) { // to get object from user
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}") // localhost:8080/api/v1/student/2
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId,name,email);
    }


}
