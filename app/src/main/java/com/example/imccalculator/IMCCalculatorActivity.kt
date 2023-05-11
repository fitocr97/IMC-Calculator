package com.example.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class IMCCalculatorActivity : AppCompatActivity() {
    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false

    //declare components to initialize them and use them anywhere
    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imccalculator)
        initComponents()
        initListeners()
        initUI()
    }

    //function to initialize components
    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
    }

    //function to know when a card is pressed
    private fun initListeners() {
        viewMale.setOnClickListener{
            changeGender()
            setGenderColor()
        }

        viewFemale.setOnClickListener{
            changeGender()
            setGenderColor()
        }
    }

    private fun changeGender(){
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor(){
        viewMale.setCardBackgroundColor(getBackgraundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgraundColor(isFemaleSelected))
    }

    private fun getBackgraundColor(isSelectedComponent: Boolean):Int{
        val colorReference = if (isSelectedComponent){
            R.color.background_component_selected
        }else{
            R.color.background_component
        }

        return ContextCompat.getColor(this,colorReference)
    }

    private fun initUI(){
        setGenderColor()
    }




}