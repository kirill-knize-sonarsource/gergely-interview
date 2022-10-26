package com.interview.calculator;

import com.interview.calculator.dto.Operation;
import com.interview.calculator.enums.Expressions;
import com.interview.calculator.services.Calculate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateTest {


    @Test
    void testCalculate() {
        Calculate calculate = new Calculate();
        Operation operation = new Operation(Expressions.ADD, new BigDecimal(5));
        BigDecimal result = calculate.calculate(operation);
        assertEquals(new BigDecimal(5), result);

    }


}
