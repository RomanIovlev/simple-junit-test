package com.simple.example.tests;

import com.simple.example.calc.Calculator;
import com.simple.example.calc.ILog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTests implements ILog {

    @Test
    public void simpleTest() {
        Calculator calc = new Calculator();
        int multiplication = calc.multiply(3,5);
        assertEquals(multiplication, 15);
        int sum = calc.sum(2,8);
        assertEquals(sum, 10);
        int division = calc.divide(12,3);
        assertEquals(division, 4);
    }
}
