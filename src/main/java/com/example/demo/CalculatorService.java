package com.example.demo;

import org.springframework.stereotype.Service;


@Service
public class CalculatorService {


    public int calculatorPlus(int a, int b) {
        return a + b;
    }

    public int calculatorMinus(int a, int b) {
        return a - b;
    }

    public int calculatorMultiply(int a, int b) {
        return a * b;
    }

    public int calculatorDivide(int a, int b) throws IllegalArgumentException{
        if (b == 0)
            throw new IllegalArgumentException("На ноль делить нельзя");
        else {
            return a / b;
        }


    }
}

