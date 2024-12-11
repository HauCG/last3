package com.example.final_ex_three.dao.borrowCard;

import com.example.final_ex_three.connection.DatabaseConnection;
import com.example.final_ex_three.model.BorrowCard;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BorrowCardDaoImpl implements BorrowCardDao {

    private final DatabaseConnection dtbc = new DatabaseConnection();

    private static final String ADD_BORROW_CARD_QUERY = "INSERT INTO BorrowCards (BookID, StudentID, Status, BorrowDate, ReturnDate) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_BORROW_CARD_QUERY = "UPDATE BorrowCards SET BookID = ?, StudentID = ?, Status = ?, BorrowDate = ?, ReturnDate = ? WHERE BorrowCardID = ?";
    private static final String DELETE_BORROW_CARD_QUERY = "DELETE FROM BorrowCards WHERE BorrowCardID = ?";
    private static final String GET_BORROW_CARD_BY_ID_QUERY = "SELECT * FROM BorrowCards WHERE BorrowCardID = ?";
    private static final String GET_ALL_BORROW_CARDS_QUERY = "SELECT * FROM BorrowCards";

    @Override
    public boolean addBorrowCard(BorrowCard borrowCard) {
        try (Connection connection = dtbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_BORROW_CARD_QUERY)) {

            statement.setInt(1, borrowCard.getBookID());
            statement.setInt(2, borrowCard.getStudentID());
            statement.setString(3, borrowCard.getStatus());
            statement.setDate(4, Date.valueOf(borrowCard.getBorrowDate())); // Convert LocalDate to SQL Date
            statement.setDate(5, borrowCard.getReturnDate() != null ? Date.valueOf(borrowCard.getReturnDate()) : null); // Handle null return date

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateBorrowCard(BorrowCard borrowCard) {
        try (Connection connection = dtbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BORROW_CARD_QUERY)) {

            statement.setInt(1, borrowCard.getBookID());
            statement.setInt(2, borrowCard.getStudentID());
            statement.setString(3, borrowCard.getStatus());
            statement.setDate(4, Date.valueOf(borrowCard.getBorrowDate())); // Convert LocalDate to SQL Date
            statement.setDate(5, borrowCard.getReturnDate() != null ? Date.valueOf(borrowCard.getReturnDate()) : null); // Handle null return date
            statement.setInt(6, borrowCard.getBorrowCardID());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteBorrowCard(int borrowCardID) {
        try (Connection connection = dtbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BORROW_CARD_QUERY)) {

            statement.setInt(1, borrowCardID);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public BorrowCard getBorrowCardById(int borrowCardID) {
        try (Connection connection = dtbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_BORROW_CARD_BY_ID_QUERY)) {

            statement.setInt(1, borrowCardID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int bookID = resultSet.getInt("BookID");
                int studentID = resultSet.getInt("StudentID");
                String status = resultSet.getString("Status");
                Date borrowDate = resultSet.getDate("BorrowDate");
                Date returnDate = resultSet.getDate("ReturnDate");

                return new BorrowCard(
                        borrowCardID,
                        bookID,
                        studentID,
                        status,
                        borrowDate.toLocalDate(), // Convert SQL Date to LocalDate
                        returnDate != null ? returnDate.toLocalDate() : null // Handle null return date
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<BorrowCard> getAllBorrowCards() {
        List<BorrowCard> borrowCards = new ArrayList<>();

        try (Connection connection = dtbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_BORROW_CARDS_QUERY)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int borrowCardID = resultSet.getInt("BorrowCardID");
                int bookID = resultSet.getInt("BookID");
                int studentID = resultSet.getInt("StudentID");
                String status = resultSet.getString("Status");
                Date borrowDate = resultSet.getDate("BorrowDate");
                Date returnDate = resultSet.getDate("ReturnDate");

                borrowCards.add(new BorrowCard(
                        borrowCardID,
                        bookID,
                        studentID,
                        status,
                        borrowDate.toLocalDate(), // Convert SQL Date to LocalDate
                        returnDate != null ? returnDate.toLocalDate() : null // Handle null return date
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return borrowCards;
    }
}
