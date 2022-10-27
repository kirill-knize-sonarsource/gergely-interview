package com.interview.calculator.services;

import java.math.BigDecimal;

public interface ValueHolder {

    void saveValue(BigDecimal value);

    // Should maintain insertion order
    void printSavedValues();
    void deleteUnusedValues();
    BigDecimal lastValue();
    int size();
    void deleteAllValues();
}
