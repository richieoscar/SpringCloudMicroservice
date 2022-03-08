package com.richieoscar.student;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @PostMapping("register")
    public ResponseEntity<Student> regisiter(@RequestBody StudentRegistration request) {
        Student student = studentService.register(request);
        return new ResponseEntity<Student>(student, HttpStatus.CREATED);
    }

    @GetMapping("student-department/{id}")
    public StudentResponse getStudentWithDepartment(@PathVariable("id") Long id) {
        return studentService.getStudentWithDepartment(id);
    }
}
