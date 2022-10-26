package com.interview.calculator.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InMemoryValueHolder implements ValueHolder{

    private static List<BigDecimal> savedValues;

    static {
        savedValues =  new ArrayList<>();
        savedValues.add(new BigDecimal(0));
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

        deleteValues();
    }

    @Override
    public void deleteValues() {
        savedValues = new ArrayList<>();
        savedValues.add(new BigDecimal(0));
    }

    @Override
    public BigDecimal lastValue() {
        return savedValues.get(savedValues.size()-1);
    }

    @Override
    public int size() {
        return savedValues.size();
    }
}
