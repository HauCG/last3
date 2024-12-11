package com.example.final_ex_three.dao.student;

import com.example.final_ex_three.connection.DatabaseConnection;
import com.example.final_ex_three.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private final DatabaseConnection dtbc = new DatabaseConnection();

    private static final String ADD_STUDENT_QUERY = "INSERT INTO Students (StudentName, StudentClass) VALUES (?, ?)";
    private static final String UPDATE_STUDENT_QUERY = "UPDATE Students SET StudentName = ?, StudentClass = ? WHERE StudentID = ?";
    private static final String DELETE_STUDENT_QUERY = "DELETE FROM Students WHERE StudentID = ?";
    private static final String GET_STUDENT_BY_ID_QUERY = "SELECT * FROM Students WHERE StudentID = ?";
    private static final String GET_ALL_STUDENTS_QUERY = "SELECT * FROM Students";

    @Override
    public boolean addStudent(Student student) {
        try (Connection connection = dtbc.getConnection();
             PreparedStatement stmt = connection.prepareStatement(ADD_STUDENT_QUERY)) {

            stmt.setString(1, student.getStudentName());
            stmt.setString(2, student.getStudentClass());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateStudent(Student student) {
        try (Connection connection = dtbc.getConnection();
             PreparedStatement stmt = connection.prepareStatement(UPDATE_STUDENT_QUERY)) {

            stmt.setString(1, student.getStudentName());
            stmt.setString(2, student.getStudentClass());
            stmt.setInt(3, student.getStudentId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteStudent(int studentID) {
        try (Connection connection = dtbc.getConnection();
             PreparedStatement stmt = connection.prepareStatement(DELETE_STUDENT_QUERY)) {

            stmt.setInt(1, studentID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Student getStudentById(int studentID) {
        try (Connection connection = dtbc.getConnection();
             PreparedStatement stmt = connection.prepareStatement(GET_STUDENT_BY_ID_QUERY)) {

            stmt.setInt(1, studentID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getInt("StudentID"));
                student.setStudentName(rs.getString("StudentName"));
                student.setStudentClass(rs.getString("StudentClass"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = dtbc.getConnection();
             PreparedStatement stmt = connection.prepareStatement(GET_ALL_STUDENTS_QUERY);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getInt("StudentID"));
                student.setStudentName(rs.getString("StudentName"));
                student.setStudentClass(rs.getString("StudentClass"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
