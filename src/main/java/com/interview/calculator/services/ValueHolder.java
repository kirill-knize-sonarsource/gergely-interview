package com.interview.calculator.services;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

public interface ValueHolder {

    void saveValue(BigDecimal value);

    // Should maintain insertion order
    List<BigDecimal> retriveSavedValues();
    void deleteValues();
}
