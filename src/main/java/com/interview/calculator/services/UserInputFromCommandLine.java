package com.interview.calculator.services;


import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserInputFromCommandLine implements UserInput {


    private Scanner scanner = new Scanner(System.in);

    @Override
    public String getExpressionFromUser() {
        return scanner.nextLine();
    }
}
