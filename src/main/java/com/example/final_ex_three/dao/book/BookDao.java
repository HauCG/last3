package com.example.final_ex_three.dao.book;

import com.example.final_ex_three.model.Book;

import java.util.List;

public interface BookDao {

    boolean addBook(Book book);

    boolean updateBook(Book book);

    boolean deleteBook(int bookID);

    Book getBookById(int bookID);

    List<Book> getAllBooks();
}
