package com.techknowns.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.techknowns.entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExpenseRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    //TODO: getAll() implementation


    public Expense save(Expense expense) {
        dynamoDBMapper.save(expense);
        return expense;
    }

    public Expense getExpenseById(String expenseId) {
        return dynamoDBMapper.load(Expense.class, expenseId);
    }

    public String delete(String expenseId) {
        Expense exp = dynamoDBMapper.load(Expense.class, expenseId);
        dynamoDBMapper.delete(exp);
        return "Expense Deleted!";
    }

    public String update(String expenseId, Expense expense) {
        dynamoDBMapper.save(expense,
                new DynamoDBSaveExpression()
        .withExpectedEntry("expenseId",
                new ExpectedAttributeValue(
                        new AttributeValue().withS(expenseId)
                )));
        return expenseId;
    }
}
