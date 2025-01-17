package com.thanu.spring.boot.project.dto;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String address;

}
