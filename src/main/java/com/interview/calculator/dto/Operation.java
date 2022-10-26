package com.interview.calculator.dto;

import com.interview.calculator.enums.Expressions;

import java.math.BigDecimal;

public class Operation {

    private Expressions operator;
    private BigDecimal operand;

    public Operation() {
    }

    public Operation(Expressions operator, BigDecimal operand) {
        this.operator = operator;
        this.operand = operand;
    }

    public void setOperator(Expressions operator) {
        this.operator = operator;
    }

    public void setOperand(BigDecimal operand) {
        this.operand = operand;
    }

    public Expressions getOperator() {
        return operator;
    }

    public BigDecimal getOperand() {
        return operand;
    }
}
