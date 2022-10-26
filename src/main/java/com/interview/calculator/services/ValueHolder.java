package com.interview.calculator.services;

import java.math.BigDecimal;

public interface ValueHolder {

    void saveValue(BigDecimal value);

    // Should maintain insertion order
    void printSavedValues();
    void deleteValues();
    BigDecimal lastValue();
    int size();
}
