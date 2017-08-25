package com.jedsada.listmovieup.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jedsada.listmovieup.R;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, MainContract.MainView {

    private Button btnPlus;
    private Button btnMinus;
    private Button btnMultiply;
    private Button btnDivide;

    private EditText etNumberOne;
    private EditText etNumberTwo;

    private TextView tvResult;

    private MainController mainController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainController = new MainController(this);

        btnPlus = (Button) findViewById(R.id.btn_plus);
        btnMinus = (Button) findViewById(R.id.btn_minus);
        btnMultiply = (Button) findViewById(R.id.btn_multiply);
        btnDivide = (Button) findViewById(R.id.btn_divide);

        etNumberOne = (EditText) findViewById(R.id.et_number_one);
        etNumberTwo = (EditText) findViewById(R.id.et_number_two);

        tvResult = (TextView) findViewById(R.id.tv_result);

        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
    }

    private List<Integer> getValue() {
        int numberOne = Integer.parseInt(etNumberOne.getText().toString());
        int numberTwo = Integer.parseInt(etNumberTwo.getText().toString());
        return Arrays.asList(numberOne, numberTwo);
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_plus:
                mainController.plus(getValue().get(0), getValue().get(1));
                break;

            case R.id.btn_minus:
                mainController.minus(getValue().get(0), getValue().get(1));
                break;

            case R.id.btn_multiply:
                mainController.multiply(getValue().get(0), getValue().get(1));
                break;

            case R.id.btn_divide:
                mainController.divide(getValue().get(0), getValue().get(1));
                break;
        }
    }

    @Override
    public void setResult(String result) {
        tvResult.setText(result);
    }
}
