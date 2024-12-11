package com.example.final_ex_three.service.student;

import com.example.final_ex_three.dao.student.StudentDao;
import com.example.final_ex_three.dao.student.StudentDaoImpl;
import com.example.final_ex_three.model.Student;

import java.util.Collections;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao = new StudentDaoImpl();

    @Override
    public boolean addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public boolean deleteStudent(int studentID) {
        return studentDao.deleteStudent(studentID);
    }

    @Override
    public Student getStudentById(int studentID) {
        return studentDao.getStudentById(studentID);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }
}
