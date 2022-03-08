package com.richieoscar.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department {
    private Long id;
    private String name;
    private String code;
    private String faculty;
}
