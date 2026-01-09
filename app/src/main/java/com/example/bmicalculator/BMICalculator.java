package com.example.bmicalculator;

public class BMICalculator
{
    public static float calculateBMI(float weight, float height)
    {
        try
        {
            if (weight <= 0 || height <= 0)
            {
                throw new IllegalArgumentException("Weight and/or height must be greater than 0");
            }
            return weight / (height * height);
        } catch (RuntimeException e)
        {
            throw new RuntimeException(e);
        }
    }
    // Method to classify the BMI based on assignment ranges
    public static String getCategory(float bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            return "Normal";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
