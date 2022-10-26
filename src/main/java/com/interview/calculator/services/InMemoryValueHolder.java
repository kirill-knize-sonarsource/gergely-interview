package com.interview.calculator.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InMemoryValueHolder implements ValueHolder{

    private List<BigDecimal> savedValues = new ArrayList<>();

    @Override
    public void saveValue(BigDecimal value) {
        savedValues.add(value);
    }

    @Override
    public List<BigDecimal> retriveSavedValues() {
        return null;
    }

    @Override
    public void deleteValues() {
        savedValues = new ArrayList<>();
    }
}
