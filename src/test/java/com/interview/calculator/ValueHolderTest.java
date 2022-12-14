package com.interview.calculator;

import com.interview.calculator.dto.Operation;
import com.interview.calculator.enums.Expressions;
import com.interview.calculator.services.Calculate;
import com.interview.calculator.services.InMemoryValueHolder;
import com.interview.calculator.services.ValueHolder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValueHolderTest {

    @AfterEach
    void tearDown(){
        ValueHolder valueHolder = new InMemoryValueHolder();
        valueHolder.deleteAllValues();
    }

    @Test
    void displayCallMustRetainLastElement() {
        ValueHolder valueHolder = new InMemoryValueHolder();

        valueHolder.saveValue(new BigDecimal(0));
        valueHolder.saveValue(new BigDecimal(1));

        valueHolder.printSavedValues();

        assertEquals(new BigDecimal(1), valueHolder.lastValue());
    }

}
