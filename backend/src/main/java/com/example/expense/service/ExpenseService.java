package com.example.expense.service;

import com.example.expense.dto.ExpenseDto;
import com.example.expense.model.Expense;

import java.util.List;

public interface ExpenseService {

    Expense createExpense(ExpenseDto dto);
    List<Expense> getAllExpenses();
    Expense updateExpense(Long id, ExpenseDto dto);
    void deleteExpense(Long id);
}
