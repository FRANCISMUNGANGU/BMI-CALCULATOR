## Technical Report: BMI Calculator

# 1. Project Overview

The BMI Calculator is a streamlined Android application designed to provide users with an instantaneous Body Mass Index (BMI) calculation. By inputting weight (kilograms) and height (meters), users receive their BMI score along with a health category classification.

* Primary Objective: To provide a fast, offline-capable tool for health monitoring.
* Target Device: Android (Minimum SDK 21+).


# 2. Technical Stack

This project was built using native Android development tools to ensure a lightweight footprint and high performance.

* Language: Java
* UI Framework: XML (View-based system)
* Development Environment: Android Studio
* Build System: Gradle


# 3. Implementation Logic

The core functionality is handled within a single Activity to minimize overhead. The calculation follows the standard World Health Organization formula:
BMI = weight(kg)/height(m)2

# Logic Components:

1. Input Validation: The app checks for empty fields or zero-value inputs to prevent `ArithmeticException` (division by zero) and app crashes.
2. View Binding: Utilizes `findViewById` to link Java logic with the XML layout components.
3. Dynamic Feedback: The app not only calculates the number but also parses the result into categories:
   Underweight: < 18.5
   Normal: 18.5 – 25.0
   Overweight: 25.0 – 30.0
   Obese: > 30.0


# 4. User Interface Design

The UI was constructed using XML Layouts focusing on the following principles:

a. Input Types: `EditText` fields are restricted to `numberDecimal` to ensure the soft keyboard only shows numeric options.
b. Accessibility: Clear labeling and high-contrast text for readability.
c. Responsiveness: Uses `LinearLayout` to ensure the UI remains consistent across different screen sizes.

