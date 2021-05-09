package com.techknowns.controller;

import com.techknowns.entity.Expense;
import com.techknowns.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;


    @CrossOrigin
    @PostMapping("/expense")
    public Expense saveEmployee(@RequestBody Expense expense) {
        return expenseRepository.save(expense);
    }

    @CrossOrigin
    @GetMapping("/expense/{id}")
    public Expense getEmployee(@PathVariable("id") String expenseId) {
        return expenseRepository.getExpenseById(expenseId);
    }

    @DeleteMapping("/expense/{id}")
    public String deleteEmployee(@PathVariable("id") String employeeId) {
        return  expenseRepository.delete(employeeId);
    }

    @PutMapping("/expense/{id}")
    public String updateEmployee(@PathVariable("id") String employeeId, @RequestBody Expense expense) {
        return expenseRepository.update(employeeId, expense);
    }
}
