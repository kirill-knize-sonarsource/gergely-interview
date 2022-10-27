package com.interview.calculator.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InMemoryValueHolder implements ValueHolder{

    private static List<BigDecimal> savedValues;
    private static BigDecimal lastValue;

    static {
        savedValues =  new ArrayList<>();
        lastValue = new BigDecimal(0);
    }
    @Override
    public void saveValue(BigDecimal value) {
        savedValues.add(value);
    }

    @Override
    public void printSavedValues() {
        for (BigDecimal decimal : savedValues) {
            System.out.println(decimal);
        }

        deleteUnusedValues();
    }

    @Override
    public void deleteUnusedValues() {
        lastValue = lastValue();
        savedValues = new ArrayList<>();
    }

    @Override
    public BigDecimal lastValue() {
        if (savedValues.isEmpty()) {
            return lastValue;
        }
        return savedValues.get(savedValues.size()-1);
    }

    @Override
    public int size() {
        return savedValues.size();
    }

    @Override
    public void deleteAllValues() {
        savedValues = new ArrayList<>();
    }
}
