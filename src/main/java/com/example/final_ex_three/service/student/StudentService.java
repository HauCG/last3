package com.example.final_ex_three.service.student;

import com.example.final_ex_three.model.Student;

import java.util.List;

public interface StudentService {
    boolean addStudent(Student student);

    boolean updateStudent(Student student);

    boolean deleteStudent(int studentID);

    Student getStudentById(int studentID);

    List<Student> getAllStudents();
}
