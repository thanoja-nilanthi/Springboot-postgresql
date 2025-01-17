package com.thanu.spring.boot.project.service.impl;

import com.thanu.spring.boot.project.dto.StudentDto;
import com.thanu.spring.boot.project.entity.Student;
import com.thanu.spring.boot.project.exception.ResourceNotFoundException;
import com.thanu.spring.boot.project.mapper.StudentMapper;
import com.thanu.spring.boot.project.repository.StudentRepository;
import com.thanu.spring.boot.project.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student= StudentMapper.mapToStudent(studentDto);
        Student savedStudent= studentRepository.save(student);

        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
      Student student =  studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student is not exists with given id: "+studentId));
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student>students = studentRepository.findAll();
        return students.stream().map((student) ->StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto updatedStudent) {
       Student student = studentRepository.findById(studentId).orElseThrow(
                ()-> new ResourceNotFoundException("Student is not exists with given id: "+ studentId));

       student.setFirstName(updatedStudent.getFirstName());
       student.setLastName(updatedStudent.getLastName());
       student.setAge(updatedStudent.getAge());
       student.setAddress(updatedStudent.getAddress());

      Student updatedStudentObj = studentRepository.save(student);

       return StudentMapper.mapToStudentDto(updatedStudentObj);
    }

    @Override
    public void deleteStudent(Long studentId) {

        Student student = studentRepository.findById(studentId).orElseThrow(
                ()-> new ResourceNotFoundException("Student is not exists with given id: "+ studentId));

        studentRepository.deleteById(studentId);
    }
}
