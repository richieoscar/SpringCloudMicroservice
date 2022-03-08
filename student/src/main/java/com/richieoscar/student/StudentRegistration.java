package com.richieoscar.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentRegistration {
    private String firstName;
    private String lastName;
    private String matriculationNumber;
    private String email;
    private Long departmentId;
}
