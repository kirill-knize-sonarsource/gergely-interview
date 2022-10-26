package com.interview.calculator.services;


import java.util.Scanner;


public class UserInputFromCommandLine implements UserInput {


    private Scanner scanner = new Scanner(System.in);

    @Override
    public String getExpressionFromUser() {
        return scanner.nextLine();
    }
}
