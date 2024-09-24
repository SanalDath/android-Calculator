package com.example.calculatorg;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private TextView textResult;
    private String input = "";
    private String operator = "";
    private Double valueOne, valueTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResult = findViewById(R.id.textResult);

        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSubtract = findViewById(R.id.btnSubtract);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnDivide = findViewById(R.id.btnDivide);
        Button btnEqual = findViewById(R.id.btnEqual);
        Button btnDot = findViewById(R.id.btnDot);

        // Number button click listeners
        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                input += button.getText().toString();
                textResult.setText(input);
            }
        };

        btn0.setOnClickListener(numberListener);
        btn1.setOnClickListener(numberListener);
        btn2.setOnClickListener(numberListener);
        btn3.setOnClickListener(numberListener);
        btn4.setOnClickListener(numberListener);
        btn5.setOnClickListener(numberListener);
        btn6.setOnClickListener(numberListener);
        btn7.setOnClickListener(numberListener);
        btn8.setOnClickListener(numberListener);
        btn9.setOnClickListener(numberListener);

        // Operator button click listeners
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOperator("+");
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOperator("-");
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOperator("*");
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOperator("/");
            }
        });

        // Equal button listener
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operator.equals("")) return;

                valueTwo = Double.parseDouble(input);
                Double result = performOperation();
                textResult.setText(result.toString());

                // Reset values
                input = "";
                operator = "";
                valueOne = null;
            }
        });

        // Dot button listener
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += ".";
                textResult.setText(input);
            }
        });
    }

    private void handleOperator(String operatorSymbol) {
        if (!input.equals("")) {
            valueOne = Double.parseDouble(input);
            operator = operatorSymbol;
            input = "";
        }
    }

    private Double performOperation() {
        switch (operator) {
            case "+":
                return valueOne + valueTwo;
            case "-":
                return valueOne - valueTwo;
            case "*":
                return valueOne * valueTwo;
            case "/":
                return valueOne / valueTwo;
            default:
                return 0.0;
        }
    }
}
