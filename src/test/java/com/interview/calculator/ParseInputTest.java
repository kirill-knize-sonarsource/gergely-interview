package com.interview.calculator;

import com.interview.calculator.dto.Operation;
import com.interview.calculator.enums.Expressions;
import com.interview.calculator.services.ParseInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ParseInputTest {

    @Test
    void inputParsingTest() {
        ParseInput parseInput = new ParseInput();
        Operation result = parseInput.parseInput("ADD 5");
        Operation expected = new Operation(Expressions.ADD, new BigDecimal(5));
        Assertions.assertEquals(expected.getOperand(), result.getOperand());
        Assertions.assertEquals(expected.getOperator(), result.getOperator());
    }
}
