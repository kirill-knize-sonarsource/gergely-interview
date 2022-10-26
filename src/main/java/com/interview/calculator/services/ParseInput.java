package com.interview.calculator.services;

import com.interview.calculator.dto.Operation;
import com.interview.calculator.enums.Expressions;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseInput {

    public Operation parseInput(String userInput) {
        Operation operation = new Operation();

        for (Expressions expression : Expressions.values()) {
            if (userInput.contains(expression.getCommand())) {
                operation.setOperator(expression);
                
                Pattern p = Pattern.compile("(\\d+)");
                Matcher m = p.matcher(userInput);

                while(m.find())
                {
                    operation.setOperand(BigDecimal.valueOf(Long.parseLong(m.group(1))));
                }

            }
        }
        return operation;
    }


}
