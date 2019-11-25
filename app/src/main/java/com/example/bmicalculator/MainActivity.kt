package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.drawable.toDrawable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalc.setOnClickListener { calBMI() }
        buttonReset.setOnClickListener { reset() }

    }

    fun calBMI(){
        val weight: Double = editTextWeight.text.toString().toDouble()
        val height: Double = ( editTextHeight.text.toString().toDouble() ) / 100

        val bmi: Double = weight / (height * height)

        displayResult(bmi)
    }

    fun displayResult(bmi:Double){

        val result: String

        if(bmi >= 25){
            result = "Overweight"
            imageViewResult.setImageResource(R.drawable.over)
        }
        else if(bmi >= 18.5){
            result = "Normal"
            imageViewResult.setImageResource(R.drawable.normal)
        }
        else {
            result = "Underweight"
            imageViewResult.setImageResource(R.drawable.under)
        }

        textViewResult.text = "BMI: %.2f (%s)".format(bmi, result)

    }

    fun reset(){

        imageViewResult.setImageResource(R.drawable.empty)
        textViewResult.setText(R.string.bmi)
        editTextWeight.text.clear()
        editTextHeight.text.clear()
        editTextWeight.requestFocus()

    }

}
