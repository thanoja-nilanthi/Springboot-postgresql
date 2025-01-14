package com.thanu.spring.boot.project.repository;

import com.thanu.spring.boot.project.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentRepository extends JpaRepository <Student, Long> {
}
