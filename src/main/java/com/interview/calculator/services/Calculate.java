package com.interview.calculator.services;


import com.interview.calculator.dto.Operation;
import com.interview.calculator.enums.Expressions;

import java.math.BigDecimal;

public class Calculate {

    ValueHolder valueHolder;

    public Calculate() {
        this.valueHolder = new InMemoryValueHolder();
    }

    public BigDecimal calculate(Operation operation) {
        BigDecimal newData = new BigDecimal(0);
        if (operation.getOperator().equals(Expressions.ADD)) {
            newData = valueHolder.lastValue().add(operation.getOperand());
            valueHolder.saveValue(newData);
        }
        return newData;
    }
}
