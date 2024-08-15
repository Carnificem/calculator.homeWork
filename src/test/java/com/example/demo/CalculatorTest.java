package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void calculatorPlus() {
        assertEquals(10, calculatorService.calculatorPlus(5, 5));
    }

    @Test
    void calculatorMinus() {
        assertEquals(0, calculatorService.calculatorMinus(5, 5));
    }

    @Test
    void calculatorMultiplay() {
        assertEquals(25, calculatorService.calculatorMultiplay(5, 5));
    }

    @Test
    void calculatorDivide() throws Exception {
        assertEquals(1, calculatorService.calculatorDivide(5, 3));
    }
}

