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

        public int calculatorMultiplay(int a, int b) {
            return a * b;
        }

        public int calculatorDivide(int a, int b)throws Exception {
            if (b==0) throw new Exception("На ноль делить нельзя");
            else {return a / b;}


        }
    }

