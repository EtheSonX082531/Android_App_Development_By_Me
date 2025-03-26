package com.example.decimaltobinaryconverter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView result;
    private Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        StringBuilder res = new StringBuilder();
        editText = findViewById(R.id.editText);
        result = findViewById(R.id.result);
        convert = findViewById(R.id.convert);

        convert.setOnClickListener(v -> {
            String decimal = editText.getText().toString();
            if (decimal.isEmpty()) {
                result.setText("Please enter a decimal number!");
            } else {
                int decimalNumber = Integer.parseInt(decimal);
                String a="";
                while(decimalNumber!=0){
                    int x=decimalNumber%2;
                    String y=Integer.toString(x);
                    a=a+y;
                    decimalNumber=decimalNumber/2;
                }
                res.append(a);
                res.reverse();
                result.setText(res);
            }
                });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
