package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView Operand1, Operand2, Operation, Result;
    Button Plus, Minus, Divide, Multiple, Clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Operand1 = findViewById(R.id.Operand1);
        Operand2 = findViewById(R.id.Operand2);
        Operation = findViewById(R.id.Operation);
        Result = findViewById(R.id.Result);

        Plus = findViewById(R.id.Plus);
        Minus = findViewById(R.id.Minus);
        Divide = findViewById(R.id.Divide);
        Multiple = findViewById(R.id.Multiple);
        Clear = findViewById(R.id.Clear);

        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operand1.setText("");
                Operand2.setText("");
                Result.setText("0");
            }
        });

        Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operation.setText("+");

                double operand1 = Double.parseDouble(Operand1.getText().toString());
                double operand2 = Double.parseDouble(Operand2.getText().toString());

                double result = operand1 + operand2;
                String strResult = Double.toString(result);

                Result.setText(strResult);
            }
        });

        Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operation.setText("-");

                double operand1 = Double.parseDouble(Operand1.getText().toString());
                double operand2 = Double.parseDouble(Operand2.getText().toString());

                double result = operand1 - operand2;
                String strResult = Double.toString(result);

                Result.setText(strResult);
            }
        });

        Multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operation.setText("x");

                double operand1 = Double.parseDouble(Operand1.getText().toString());
                double operand2 = Double.parseDouble(Operand2.getText().toString());

                double result = operand1 * operand2;
                String strResult = Double.toString(Math.round(result * 10000.0) / 10000.0);

                Result.setText(strResult);
            }
        });

        Divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operation.setText("/");

                double operand1 = Double.parseDouble(Operand1.getText().toString());
                double operand2 = Double.parseDouble(Operand2.getText().toString());

                if (operand2 != 0) {
                    double result = operand1 / operand2;
                    String strResult = Double.toString(Math.round(result * 10000.0) / 10000.0);
                    Result.setText(strResult);
                } else {
                    Result.setText("∞");
                    Toast toast = Toast.makeText(MainActivity.this, "Ошибка деления на ноль!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}