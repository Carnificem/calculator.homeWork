package com.example.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParameterizedTestByCalculator {
    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @CsvSource({"1,1,2",
            "2,2,4",
            "3,3,6",
            "4,4,8",
            "5,5,10",
            "6,6,12",
            "7,7,14",
            "8,8,16",
            "9,9,18",
            "-1,1,0"})
    void testCalculatorPlus(int a, int b, int expect) {
        assertEquals(calculatorService.calculatorPlus(a, b), expect);
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> ArgumentByTest() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(1, 1, 1),
                org.junit.jupiter.params.provider.Arguments.of(2, 2, 4),
                org.junit.jupiter.params.provider.Arguments.of(3, 9, 27),
                org.junit.jupiter.params.provider.Arguments.of(4, 8, 32),
                org.junit.jupiter.params.provider.Arguments.of(5, 16, 80)
        );
    }

    @ParameterizedTest
    @MethodSource("ArgumentByTest")
    void testMinus(int a, int b, int expect) {
        assertEquals(expect, calculatorService.calculatorMinus(a, b), "Вычитание не верно");
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> testMethodMinus() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(1, 1, 0),
                org.junit.jupiter.params.provider.Arguments.of(2, 2, 0),
                org.junit.jupiter.params.provider.Arguments.of(3, 9, -6),
                org.junit.jupiter.params.provider.Arguments.of(4, 8, -4),
                org.junit.jupiter.params.provider.Arguments.of(5, 16, -11)
        );
    }

    @ParameterizedTest
    @MethodSource("testMethodMultiply")
    void testMultiply(int a, int b, int expect) {
        assertEquals(expect, calculatorService.calculatorMultiply(a, b), "умножение не верно");
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> testMethodMultiply() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(1, 1, 1),
                org.junit.jupiter.params.provider.Arguments.of(2, 2, 4),
                org.junit.jupiter.params.provider.Arguments.of(3, 9, 27),
                org.junit.jupiter.params.provider.Arguments.of(4, 8, 32),
                org.junit.jupiter.params.provider.Arguments.of(5, 16, 80)
        );
    }

    @ParameterizedTest
    @MethodSource("testMethodDivide")
    void testDivide(int a, int b, int expect) {
        assertEquals(expect, calculatorService.calculatorDivide(a, b));
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> testMethodDivide() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(1, 1, 1),
                org.junit.jupiter.params.provider.Arguments.of(4, 2, 2),
                org.junit.jupiter.params.provider.Arguments.of(27, 9, 3),
                org.junit.jupiter.params.provider.Arguments.of(32, 4, 8),
                org.junit.jupiter.params.provider.Arguments.of(80, 16, 5)
        );
    }


    //static Stream<Integer> provideByNull(){
    //  return Stream.of(0);
    //}
    @ParameterizedTest
    @CsvSource({"0"})
    void testIllegalArgumentException(int input) {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.calculatorDivide(1, input));
    }
}
