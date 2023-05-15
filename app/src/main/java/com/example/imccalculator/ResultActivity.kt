package com.example.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imccalculator.IMCCalculatorActivity.Companion.IMC_KEY

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val result:Double = intent.extras?.getDouble(IMC_KEY)?:-1.0
    }
}