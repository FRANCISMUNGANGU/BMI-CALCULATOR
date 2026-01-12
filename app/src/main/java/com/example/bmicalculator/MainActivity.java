package com.example.bmicalculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.button.MaterialButton;

import java.util.Locale;

public class  MainActivity extends AppCompatActivity {
    TextInputEditText etWeight;
    TextInputEditText etHeight;
    MaterialButton btnCalculate;
    TextView tvResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//       WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(v -> {
            if (!validateInput()) {
                if (etWeight.getText() == null || etWeight.getText().toString().trim().isEmpty()) {
                    etWeight.setError("Required");
                }
                if (etHeight.getText() == null || etHeight.getText().toString().trim().isEmpty()) {
                    etHeight.setError("Required");
                }
                return; // Stop if validation fails
            }
            try {
                float weight = Float.parseFloat(String.valueOf(etWeight.getText()));
                float height = Float.parseFloat(String.valueOf(etHeight.getText()));

                float bmi = BMICalculator.calculateBMI(weight, height);
                String category = BMICalculator.getCategory(bmi);

                // Display the final result in the TextView
                tvResult.setText(String.format(Locale.US, "BMI: %.2f\nCategory: %s", bmi, category));

            } catch (NumberFormatException e) {
                etWeight.setError("Invalid number");
            } catch (IllegalArgumentException e) {
                tvResult.setText(e.getMessage());
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