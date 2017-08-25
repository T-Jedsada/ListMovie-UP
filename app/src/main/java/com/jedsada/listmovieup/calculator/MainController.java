package com.jedsada.listmovieup.calculator;

public class MainController implements MainContract.MainControllerable {

    private Calculator calculator;

    private MainContract.MainView view;

    public MainController(MainContract.MainView view) {
        calculator = new Calculator();
        this.view = view;
    }

    @Override
    public void plus(int x, int y) {
        view.setResult(String.valueOf(calculator.plus(x, y)));
    }

    @Override
    public void minus(int x, int y) {
        view.setResult(String.valueOf(calculator.minus(x, y)));
    }

    @Override
    public void multiply(int x, int y) {
        view.setResult(String.valueOf(calculator.multiply(x, y)));
    }

    @Override
    public void divide(int x, int y) {
        view.setResult(String.valueOf(calculator.divide(x, y)));
    }
}
