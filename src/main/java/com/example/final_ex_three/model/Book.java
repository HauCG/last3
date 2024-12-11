package com.example.final_ex_three.model;

public class Book {
    private int bookID;
    private String BookName;
    private String Author;
    private String Description;
    private int Quantity;

    public Book(int bookID, String BookName, String Author, String Description, int Quantity) {
        this.bookID = bookID;
        this.BookName = BookName;
        this.Author = Author;
        this.Description = Description;
        this.Quantity = Quantity;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}

