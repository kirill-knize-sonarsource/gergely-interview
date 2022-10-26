package com.interview.calculator.eventlistener;

import com.interview.calculator.services.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ProgramFlow {

    UserInput userInput;

    @Autowired
    public ProgramFlow(UserInput userInput) {
        this.userInput = userInput;
    }

    @PostConstruct
    public void init() {
        String expressionFromUser = userInput.getExpressionFromUser();
        System.out.println(expressionFromUser);
    }
}
