package com.jedsada.listmovieup.calculator;

public class MainContract {

    public interface MainView {
        void setResult(String result);
    }

    public interface MainControllerable {
        void plus(int x, int y);

        void minus(int x, int y);

        void multiply(int x, int y);

        void divide(int x, int y);
    }
}
