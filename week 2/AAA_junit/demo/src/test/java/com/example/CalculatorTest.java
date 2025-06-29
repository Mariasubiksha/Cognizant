package com.example;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setup: Calculator object initialized.");
    }

    @After
    public void tearDown() {
        calculator = null; 
        System.out.println("Teardown: Calculator object cleaned up.");
    }

    @Test
    public void testAddition() {
        int a = 5;
        int b = 3;

        int result = calculator.add(a, b);

        assertEquals("Addition result should be 8", 8, result);
    }

    @Test
    public void testSubtraction() {
        int a = 5;
        int b = 3;

        int result = calculator.subtract(a, b);

        assertEquals("Subtraction result should be 2", 2, result);
    }

    @Test
    public void testMultiplication() {
        int a = 5;
        int b = 3;

        int result = calculator.multiply(a, b);

        assertEquals("Multiplication result should be 15", 15, result);
    }

    @Test
    public void testDivision() {
        int a = 6;
        int b = 3;

        int result = calculator.divide(a, b);

        assertEquals("Division result should be 2", 2, result);
    }
}
