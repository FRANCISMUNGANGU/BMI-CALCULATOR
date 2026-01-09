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
            return weight * height * height;
        } catch (RuntimeException e)
        {
            throw new RuntimeException(e);
        }
    }
}
