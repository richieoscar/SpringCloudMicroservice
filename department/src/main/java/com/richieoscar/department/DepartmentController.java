package com.richieoscar.department;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/department")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping("save")
    public ResponseEntity<Department> saveDepartment(@RequestBody DepartmentRequest request) {
        Department department = departmentService.save(request);
        return new ResponseEntity<Department>(department,HttpStatus.CREATED);
    }

    @GetMapping("/get-department/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable("id") Long departmentId) {
        Department department = departmentService.getDepartment(departmentId);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }
}
