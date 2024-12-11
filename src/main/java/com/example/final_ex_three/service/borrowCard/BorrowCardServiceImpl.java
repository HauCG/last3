package com.example.final_ex_three.service.borrowCard;

import com.example.final_ex_three.dao.borrowCard.BorrowCardDao;
import com.example.final_ex_three.dao.borrowCard.BorrowCardDaoImpl;
import com.example.final_ex_three.dao.student.StudentDao;
import com.example.final_ex_three.dao.student.StudentDaoImpl;
import com.example.final_ex_three.model.BorrowCard;

import java.util.Collections;
import java.util.List;

public class BorrowCardServiceImpl implements BorrowCardService {
    private final BorrowCardDao borrowCardDao = new BorrowCardDaoImpl();

    @Override
    public boolean addBorrowCard(BorrowCard borrowCard) {
        return borrowCardDao.addBorrowCard(borrowCard);
    }

    @Override
    public boolean updateBorrowCard(BorrowCard borrowCard) {
        return borrowCardDao.updateBorrowCard(borrowCard);
    }

    @Override
    public boolean deleteBorrowCard(int borrowCardID) {
        return borrowCardDao.deleteBorrowCard(borrowCardID);
    }

    @Override
    public BorrowCard getBorrowCardById(int borrowCardID) {
        return borrowCardDao.getBorrowCardById(borrowCardID);
    }

    @Override
    public List<BorrowCard> getAllBorrowCards() {
        return borrowCardDao.getAllBorrowCards();
    }
}
