package com.example.final_ex_three.dao.borrowCard;

import com.example.final_ex_three.model.BorrowCard;

import java.util.List;

public interface BorrowCardDao {
    boolean addBorrowCard(BorrowCard borrowCard);

    boolean updateBorrowCard(BorrowCard borrowCard);

    boolean deleteBorrowCard(int borrowCardID);

    BorrowCard getBorrowCardById(int borrowCardID);

    List<BorrowCard> getAllBorrowCards();
}
