package com.expense.Expensetracker.controller;

import com.expense.Expensetracker.model.Expense;
import com.expense.Expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @GetMapping("/expense")
    public List<Expense> get()
    {
        return this.expenseService.get();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addingExpense(@RequestBody Expense expense)
    {
        this.expenseService.addExpense(expense);
        return new ResponseEntity<>("Added",HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id)
    {
        expenseService.deleteExpense(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
