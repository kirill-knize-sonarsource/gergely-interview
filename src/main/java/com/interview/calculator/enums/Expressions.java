package com.interview.calculator.enums;

import java.math.BigDecimal;

public enum Expressions {
    ADD("ADD"),
    SUBTRACT("SUBTRACT");

    private String command;

    Expressions(String command) {
        this.command = command;
    }



    public String getCommand() {
        return command;
    }
}
