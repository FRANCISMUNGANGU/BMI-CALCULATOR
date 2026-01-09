package com.example.bmicalculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.button.MaterialButton;

public class  MainActivity extends AppCompatActivity {
    TextInputEditText etWeight;
    TextInputEditText etHeight;
    MaterialButton btnCalculate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//       WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(v -> {
            if (!validateInput()) {
                if (etWeight.getText() == null || etWeight.getText().toString().trim().isEmpty()) {
                    etWeight.setError("Required");
                }
                if (etHeight.getText() == null || etHeight.getText().toString().trim().isEmpty()) {
                    etHeight.setError("Required");
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /*
         -> Example usage of BMICalculator.calculateBMI(float weight, float height);
        float bmi = BMICalculator.calculateBMI(1.1f, 2.2f);
        */
    }
    private boolean validateInput() {
        return etWeight.getText() != null &&
                etHeight.getText() != null &&
                !etWeight.getText().toString().trim().isEmpty() &&
                !etHeight.getText().toString().trim().isEmpty();
    }





}