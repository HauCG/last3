package com.example.final_ex_three.dao.book;

import com.example.final_ex_three.connection.DatabaseConnection;
import com.example.final_ex_three.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private final DatabaseConnection dtbc = new DatabaseConnection();

    private static final String INSERT_BOOK_SQL = "INSERT INTO Books (BookName, Author, Description, Quantity) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_BOOK_SQL = "UPDATE Books SET BookName = ?, Author = ?, Description = ?, Quantity = ? WHERE BookID = ?";
    private static final String DELETE_BOOK_SQL = "DELETE FROM Books WHERE BookID = ?";
    private static final String SELECT_BOOK_BY_ID_SQL = "SELECT * FROM Books WHERE BookID = ?";
    private static final String SELECT_ALL_BOOKS_SQL = "SELECT * FROM Books";

    @Override
    public boolean addBook(Book book) {
        try (Connection conn = dtbc.getConnection(); PreparedStatement stmt = conn.prepareStatement(INSERT_BOOK_SQL)) {
            stmt.setString(1, book.getBookName());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getDescription());
            stmt.setInt(4, book.getQuantity());
            int lineChangeS = stmt.executeUpdate();
            return lineChangeS > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateBook(Book book) {
        try (Connection conn = dtbc.getConnection(); PreparedStatement stmt = conn.prepareStatement(UPDATE_BOOK_SQL)) {
            stmt.setString(1, book.getBookName());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getDescription());
            stmt.setInt(4, book.getQuantity());
            stmt.setInt(5, book.getBookID());
            int lineChangeS = stmt.executeUpdate();
            return lineChangeS > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteBook(int bookID) {
        try (Connection conn = dtbc.getConnection(); PreparedStatement stmt = conn.prepareStatement(DELETE_BOOK_SQL)) {
            stmt.setInt(1, bookID);
            int lineChangeS = stmt.executeUpdate();
            return lineChangeS > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Book getBookById(int bookID) {
        Book book = null;
        try (Connection conn = dtbc.getConnection(); PreparedStatement stmt = conn.prepareStatement(SELECT_BOOK_BY_ID_SQL)) {
            stmt.setInt(1, bookID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    book = new Book(
                            rs.getInt("BookID"),
                            rs.getString("BookName"),
                            rs.getString("Author"),
                            rs.getString("Description"),
                            rs.getInt("Quantity")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection conn = dtbc.getConnection(); PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_BOOKS_SQL);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                books.add(new Book(
                        rs.getInt("BookID"),
                        rs.getString("BookName"),
                        rs.getString("Author"),
                        rs.getString("Description"),
                        rs.getInt("Quantity")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (books.isEmpty()) {
            return null;
        }
        return books;
    }

}
