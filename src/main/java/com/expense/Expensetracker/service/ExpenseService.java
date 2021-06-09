package com.expense.Expensetracker.service;
import com.expense.Expensetracker.model.Expense;
import com.expense.Expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    public List<Expense> get() {
        return this.expenseRepository.findAll();
    }


    public void addExpense(Expense expense) {
        this.expenseRepository.save(expense);
    }



    public void deleteExpense(int id) {

        Expense e = expenseRepository.getById(id);
        this.expenseRepository.delete(e);
    }

}
