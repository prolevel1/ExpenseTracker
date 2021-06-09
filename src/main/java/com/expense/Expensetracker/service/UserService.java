package com.expense.Expensetracker.service;

import com.expense.Expensetracker.model.Expense;
import com.expense.Expensetracker.model.User;
import com.expense.Expensetracker.repository.ExpenseRepository;
import com.expense.Expensetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ExpenseRepository expenseRepository;

    public List<User> getUser()
    {
        return this.userRepository.findAll();
    }

    public User getUserById(int id)
    {
        Optional<User> user=this.userRepository.findById(id);
        if(user.isEmpty())
        {
            return null;
        }
        else{
            return user.get();
        }
    }
    public List<Expense> getAllExpense(int id)
    {
        User u=getUserById(id);
        return u.getExpenseList();
    }
    public void addExpense(Expense expense, int id)
    {
        User u=userRepository.getById(id);
        u.getExpenseList().add(expense);
        expense.setUser(u);
        userRepository.save(u);
        expenseRepository.save(expense);

    }


    public void addUser(User user)
    {
        this.userRepository.save(user);
    }
   public void deleteUser(int id)
   {
       User u = userRepository.getById(id);
       this.userRepository.delete(u);
   }
}
