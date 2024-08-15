package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/calculator")

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }


    @GetMapping()
    public String calculator() {
        return ("Добро пожаловать в калькулятор");
    }

    @GetMapping(path = "/plus")
    public String calculatorPlus(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        return a + "+" + b + "=" + calculatorService.calculatorPlus(a, b);

    }

    @GetMapping(path = "/minus")
    public String calculatorMinus(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        return a + "-" + b + "=" + calculatorService.calculatorMinus(a, b);
    }

    @GetMapping(path = "/multiplay")
    public String calculatorMultiplay(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        return a + "*" + b + "=" + calculatorService.calculatorMultiplay(a, b);
    }

    @GetMapping(path = "/divide")
    public String calculatorDivide(@RequestParam("num1") int a, @RequestParam("num2") int b) throws Exception {

        return a + "/" + b + "=" + calculatorService.calculatorDivide(a, b);

    }
}

