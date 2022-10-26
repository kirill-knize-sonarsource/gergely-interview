package com.interview.calculator.services;

import java.math.BigDecimal;
import java.util.List;

public class InMemoryValueHolder implements ValueHolder{
    @Override
    public void saveValue(BigDecimal value) {

    }

    @Override
    public List<BigDecimal> retriveSavedValues() {
        return null;
    }

    @Override
    public void deleteValues() {

    }
}
