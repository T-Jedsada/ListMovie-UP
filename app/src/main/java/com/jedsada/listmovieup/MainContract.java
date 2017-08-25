package com.jedsada.listmovieup;

class MainContract {

    interface MainView {
        void setResult(String result);
    }

    interface MainControllerable {
        void plus(int x, int y);

        void minus(int x, int y);

        void multiply(int x, int y);

        void divide(int x, int y);
    }
}
