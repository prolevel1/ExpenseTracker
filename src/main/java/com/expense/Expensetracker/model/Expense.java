package com.expense.Expensetracker.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
@Getter
@Setter
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Instant expenseDate;
    private String description;

    @ManyToOne
    private User user;


}
