package com.richieoscar.student;

import jdk.jfr.consumer.RecordedStackTrace;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;
    private RestTemplate restTemplate;

    public Student register(StudentRegistration request) {
        Student student = Student.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .matriculationNumber(request.getMatriculationNumber())
                .departmentId(request.getDepartmentId())
                .build();
        return studentRepository.save(student);

    }

    public StudentResponse getStudentWithDepartment(Long id) {
        StudentResponse studentResponse = new StudentResponse();
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(String.format("Student with %d not founnd", id)));
        Department department = restTemplate.getForObject("http://localhost:9000/department/api/v1/department/get-department/" + student.getDepartmentId(),
                        Department.class);
        studentResponse.setStudent(student);
        studentResponse.setDepartment(department);
        return studentResponse;
    }
}
