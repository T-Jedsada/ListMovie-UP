package com.jedsada.listmovieup;

import junit.framework.Assert;

import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void plus() throws Exception {
        int result = calculator.plus(5,5);
        Assert.assertEquals(10, result);
    }

    @Test
    public void minus() throws Exception {
        int result = calculator.minus(5,5);
        Assert.assertEquals(0, result);
    }

    @Test
    public void multiply() throws Exception {
        int result = calculator.multiply(5,5);
        Assert.assertEquals(25, result);
    }

    @Test
    public void divide() throws Exception {
        int result = calculator.divide(5,5);
        Assert.assertEquals(1, result);
    }

    @Test
    public void divideByZero() throws Exception {
        int result = calculator.divide(1,0);
        Assert.assertEquals(0, result);
    }
}