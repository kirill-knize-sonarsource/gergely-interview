package com.interview.calculator;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.interview.calculator.services.UserInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EndToEnd {

    @Mock
    UserInput userInput;

    @Test
    void testAddition(){
        Mockito.when(userInput.getExpressionFromUser()).thenReturn("ADD 5");
        String expressionFromUser = userInput.getExpressionFromUser();
        System.out.println(expressionFromUser);
    }
}
