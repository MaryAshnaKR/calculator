package com.example.ques1;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

// Explicit import for the R class
import com.example.ques1.R;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2;
    TextView res;
    Button add, sub, mul, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        res = findViewById(R.id.res);

        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);

        add.setOnClickListener(v -> calculate('+'));
        sub.setOnClickListener(v -> calculate('-'));
        mul.setOnClickListener(v -> calculate('*'));
        div.setOnClickListener(v -> calculate('/'));
    }

    void calculate(char op) {

        if (e1.getText().toString().isEmpty()) {
            e1.setError("Enter first number");
            return;
        }

        if (e2.getText().toString().isEmpty()) {
            e2.setError("Enter second number");
            return;
        }

        double a = Double.parseDouble(e1.getText().toString());
        double b = Double.parseDouble(e2.getText().toString());

        double r = 0;

        switch (op) {
            case '+': 
                r = a + b; 
                break;
            case '-': 
                r = a - b; 
                break;
            case '*': 
                r = a * b; 
                break;
            case '/':
                if (b == 0) {
                    e2.setError("Cannot divide by zero");
                    return;
                }
                r = a / b;
                break;
        }

        res.setText("Result: " + r);
    }
}
