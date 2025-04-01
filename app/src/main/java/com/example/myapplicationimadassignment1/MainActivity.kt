package com.example.myapplicationimadassignment1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // this declares the EditText for time inputs
        val timeSelect = findViewById<EditText>(R.id.timeSelect)

        // Declare the Button for recommending a meal
        val recommendB = findViewById<Button>(R.id.recommendB)

        //Declare the Button for resetting the inputs
        val resetB = findViewById<Button>(R.id.resetB)

        //Declare the TextView for displaying the meal suggestion
        val outputMeals = findViewById<TextView>(R.id.outputMeals)

        //Set an OnClickListener for the recommendB button to suggest meals based on time of day
        recommendB.setOnClickListener {

            //Get the user input (time of day) and trim it to remove extra spaces, then convert it to lowercase
            val timeOfDay = timeSelect.text.toString().trim().lowercase()

            //Check the time of day and set the corresponding meal suggestion
            if (timeOfDay == "morning") {
                outputMeals.text = "omelette with a green smoothie "
            } else if (timeOfDay == "mid morning") {
                outputMeals.text = "fruits and a protien smoothie"
            } else if (timeOfDay == "afternoon") {
                outputMeals.text = "grilled chicken wrap with fruit juice"
            } else if (timeOfDay == "mid afternoon") {
                outputMeals.text = "dried fruits with a smoothie"
            } else if (timeOfDay == "supper") {
                outputMeals.text = "spaghetti bolognese with diet ginger beer"
            } else {
                outputMeals.text = "enter a valid time of day"
            }

            // Set an OnClickListener for the resetB button to clear the inputs and output
            resetB.setOnClickListener {
                // Clear the text from the EditText (timeSelect) and TextView (outputMeals)
                timeSelect.text.clear() // Clear the time of day input
                outputMeals.text = "" // Clear the output meal suggestion

                //I have Used google Chrome to enhance my knowledge on meals and drinks to use-- https://www.google.com/chrome/?brand=FHFK&ds_kid=43700078658943262&gad_source=1&gclid=Cj0KCQjwna6_BhCbARIsALId2Z1Ahq6kri1obyDT7jGIB0od0LLuCjtHaWe2bgDVlbtPxLjgM-sCx1IaAimfEALw_wcB&gclsrc=aw.ds
                // i have also used chatgpt for a better understanding of the if function and how to add diffrent colors to the buttons, This AI was not used to formulate my whole assignment at all in any way but rather for a helping source https://chatgpt.com/

            }
        }
    }
}