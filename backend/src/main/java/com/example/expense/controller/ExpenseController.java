package com.example.expense.controller;

import com.example.expense.dto.ExpenseDto;
import com.example.expense.model.Expense;
import com.example.expense.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "http://localhost:3000")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @PostMapping
    public Expense create(@Valid @RequestBody ExpenseDto dto) {
        return service.createExpense(dto);
    }

    @GetMapping
    public List<Expense> getAll() {
        return service.getAllExpenses();
    }

    @PutMapping("/{id}")
    public Expense update(@PathVariable Long id, @Valid @RequestBody ExpenseDto dto) {
        return service.updateExpense(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteExpense(id);
    }
}
