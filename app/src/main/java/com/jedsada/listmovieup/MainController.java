package com.jedsada.listmovieup;

class MainController {

    private Calculator calculator;

    private MainView view;

    MainController(MainView view) {
        calculator = new Calculator();
        this.view = view;
    }

    void plus(int x, int y) {
        view.setResult(String.valueOf(calculator.plus(x, y)));
    }

    void minus(int x, int y) {
        view.setResult(String.valueOf(calculator.minus(x, y)));
    }

    void multiply(int x, int y) {
        view.setResult(String.valueOf(calculator.multiply(x, y)));
    }

    void divide(int x, int y) {
        view.setResult(String.valueOf(calculator.divide(x, y)));
    }
}
