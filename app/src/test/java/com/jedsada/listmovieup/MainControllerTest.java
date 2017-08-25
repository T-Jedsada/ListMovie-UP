package com.jedsada.listmovieup;

import com.jedsada.listmovieup.calculator.MainContract;
import com.jedsada.listmovieup.calculator.MainController;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class MainControllerTest {

    @Mock
    private MainContract.MainView mockMainView;

    private MainController mainController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mainController = new MainController(mockMainView);
    }

    @Test
    public void plus() throws Exception {
        mainController.plus(5,5);
        Mockito.verify(mockMainView, Mockito.times(1)).setResult(String.valueOf(10));
    }

    @Test
    public void minus() throws Exception {
        mainController.minus(5,5);
        Mockito.verify(mockMainView, Mockito.times(1)).setResult(String.valueOf(0));
    }

    @Test
    public void multiply() throws Exception {
        mainController.multiply(5,5);
        Mockito.verify(mockMainView, Mockito.times(1)).setResult(String.valueOf(25));
    }

    @Test
    public void divide() throws Exception {
        mainController.divide(5,5);
        Mockito.verify(mockMainView, Mockito.times(1)).setResult(String.valueOf(1));
    }

    @Test
    public void divideByZero() throws Exception {
        mainController.divide(5,0);
        Mockito.verify(mockMainView, Mockito.times(1)).setResult(String.valueOf(0));
    }
}