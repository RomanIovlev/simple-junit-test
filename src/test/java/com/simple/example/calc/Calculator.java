package com.simple.example.calc;

public class Calculator {
    @Step
    public int multiply(int a, int b) {
        return a*b;
    }
    @Step
    public int sum(int a, int b) {
        return a+b;
    }
    @Step
    public int divide(int a, int b) {
        return a/b;
    }
}
