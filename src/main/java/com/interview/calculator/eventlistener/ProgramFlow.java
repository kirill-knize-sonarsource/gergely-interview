package com.interview.calculator.eventlistener;

import com.interview.calculator.dto.Operation;
import com.interview.calculator.services.ParseInput;
import com.interview.calculator.services.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ProgramFlow {

    UserInput userInput;
    ParseInput parseInput;

    @Autowired
    public ProgramFlow(UserInput userInput, ParseInput parseInput) {
        this.userInput = userInput;
        this.parseInput = parseInput;
    }

    @PostConstruct
    public void init() {
        String expressionFromUser = userInput.getExpressionFromUser();
        System.out.println(expressionFromUser);
        Operation operation = parseInput.parseInput(expressionFromUser);
        System.out.println(operation.getOperator());
        System.out.println(operation.getOperand());
    }
}
