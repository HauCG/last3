package com.example.final_ex_three.model;

import java.time.LocalDate;

public class BorrowCard {
    private int borrowCardID;
    private int bookID;
    private int studentID;
    private String status;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public BorrowCard(int borrowCardID, int bookID, int studentID, String status, LocalDate borrowDate, LocalDate returnDate) {
        this.borrowCardID = borrowCardID;
        this.bookID = bookID;
        this.studentID = studentID;
        this.status = status;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public BorrowCard() {

    }

    public int getBorrowCardID() {
        return borrowCardID;
    }

    public void setBorrowCardID(int borrowCardID) {
        this.borrowCardID = borrowCardID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
