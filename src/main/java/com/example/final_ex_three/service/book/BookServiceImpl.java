package com.example.final_ex_three.service.book;

import com.example.final_ex_three.dao.book.BookDao;
import com.example.final_ex_three.dao.book.BookDaoImpl;
import com.example.final_ex_three.dao.student.StudentDao;
import com.example.final_ex_three.dao.student.StudentDaoImpl;
import com.example.final_ex_three.model.Book;

import java.util.Collections;
import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookDao bookDao = new BookDaoImpl();


    @Override
    public boolean addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public boolean updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public boolean deleteBook(int bookID) {
        return bookDao.deleteBook(bookID);
    }

    @Override
    public Book getBookById(int bookID) {
        return bookDao.getBookById(bookID);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }
}
