package com.thanu.spring.boot.project.mapper;

import com.thanu.spring.boot.project.dto.StudentDto;
import com.thanu.spring.boot.project.entity.Student;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student student){
        return new StudentDto(
              student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getAge(),
                student.getAddress()
                      );
    }
    public static Student mapToStudent(StudentDto studentDto){
        return  new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getAge(),
                studentDto.getAddress()
        );
    }
}
