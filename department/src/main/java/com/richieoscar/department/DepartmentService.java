package com.richieoscar.department;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
@AllArgsConstructor
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public Department save(DepartmentRequest request) {
        Department department = Department.builder()
                .name(request.getName())
                .code(request.getCode())
                .faculty(request.getFaculty())
                .build();
        Department savedDepartment = departmentRepository.save(department);
        return  savedDepartment;
    }

    public Department getDepartment(Long depatmentId) {
        return departmentRepository.findById(depatmentId)
                .orElseThrow(() -> new DepartmentNotFoundException(String.format("Department with %d not found", depatmentId)));
    }
}
