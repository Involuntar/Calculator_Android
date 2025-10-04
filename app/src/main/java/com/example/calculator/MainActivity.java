package com.example.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

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


    }
}