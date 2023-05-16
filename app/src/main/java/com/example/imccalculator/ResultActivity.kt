package com.example.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.imccalculator.IMCCalculatorActivity.Companion.IMC_KEY

class ResultActivity : AppCompatActivity() {
    private lateinit var tvResultIMC:TextView
    private lateinit var tvIMC:TextView
    private lateinit var tvDescription:TextView
    private lateinit var btnRecalculate:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val result:Double = intent.extras?.getDouble(IMC_KEY)?:-1.0
        Log.i("fito", "$result")
        initComponents()
        initUI(result)
        initListeners()
    }

    private fun initComponents() {
        tvResultIMC = findViewById(R.id.tvResultIMC)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescription= findViewById(R.id.tvDescription)
        btnRecalculate = findViewById(R.id.btnRecalculate)
    }

    private fun initUI(result: Double) {
        tvIMC.text =result.toString()
        when(result){
            in 0.00..18.50 ->{
                tvResultIMC.text = getString(R.string.title_pesoBajo)
                tvResultIMC.setTextColor(ContextCompat.getColor(this,R.color.color_bajoPeso))
                tvDescription.text = getString(R.string.description_bajoPeso)
            }
            in 18.51..24.99 ->{
                tvResultIMC.text = getString(R.string.title_pesoNormal)
                tvResultIMC.setTextColor(ContextCompat.getColor(this,R.color.color_normal))
                tvDescription.text = getString(R.string.description_pesoNormal)
            }
            in 25.00..29.99 ->{
                tvResultIMC.text = getString(R.string.title_pesoSobrepeso)
                tvResultIMC.setTextColor(ContextCompat.getColor(this,R.color.color_sobrepeso))
                tvDescription.text = getString(R.string.description_pesoSobrepeso)
            }
            in 30.00..99.50 ->{
                tvResultIMC.text = getString(R.string.title_pesoObesidad)
                tvResultIMC.setTextColor(ContextCompat.getColor(this,R.color.color_obesidad))
                tvDescription.text = getString(R.string.description_pesoObesidad)
            }else ->{
                tvResultIMC.text = getString(R.string.error)
                tvResultIMC.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
            }
        }
    }
    private fun initListeners(){
        btnRecalculate.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }
}