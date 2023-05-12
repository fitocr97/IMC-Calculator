package com.example.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class IMCCalculatorActivity : AppCompatActivity() {
    //select genders
    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false

    //declare components to initialize them and use them anywhere
    //gender
    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    //height
    private lateinit var tvHeight:TextView
    private lateinit var rsHeight:RangeSlider

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
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
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

        //know when the slider moved
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            val result = df.format(value)
            tvHeight.text = result.toString()
        }
    }

    //change the status of the gender, if the man is selected and the woman is selected, it is changed to false and vice versa
    private fun changeGender(){
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    //change the color of the card
    private fun setGenderColor(){
        viewMale.setCardBackgroundColor(getBackgraundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgraundColor(isFemaleSelected))
    }

    //returns the color that the card has to paint
    private fun getBackgraundColor(isSelectedComponent: Boolean):Int{
        val colorReference = if (isSelectedComponent){
            R.color.background_component_selected
        }else{
            R.color.background_component
        }

        return ContextCompat.getColor(this,colorReference)
    }

    //start the interface
    private fun initUI(){
        setGenderColor()
    }




}