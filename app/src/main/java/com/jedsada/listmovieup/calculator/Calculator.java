package com.jedsada.listmovieup.calculator;

public class Calculator {

    public int plus(int x, int y) {
        return x + y;
    }

    public int minus(int x, int y) {
        return x - y;
    }

    public int multiply(int x, int y) {
        return x * y;
    }

    public int divide(int x, int y) {
        if (y == 0) return 0;
        return x / y;
    }
}
