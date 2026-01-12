package com.example.expense.service;

import com.example.expense.dto.ExpenseDto;
import com.example.expense.exception.ResourceNotFoundException;
import com.example.expense.model.Expense;
import com.example.expense.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseServiceImpl(ExpenseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Expense createExpense(ExpenseDto dto) {
        Expense expense = new Expense(
                dto.getTitle(),
                dto.getAmount(),
                dto.getCategory(),
                dto.getDate()
        );
        return repository.save(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    @Override
    public Expense updateExpense(Long id, ExpenseDto dto) {
        Expense expense = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found"));

        expense.setTitle(dto.getTitle());
        expense.setAmount(dto.getAmount());
        expense.setCategory(dto.getCategory());
        expense.setDate(dto.getDate());

        return repository.save(expense);
    }

    @Override
    public void deleteExpense(Long id) {
        Expense expense = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found"));
        repository.delete(expense);
    }
}
