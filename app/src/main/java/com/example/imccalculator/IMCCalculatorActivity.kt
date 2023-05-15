package com.example.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class IMCCalculatorActivity : AppCompatActivity() {
    //select genders
    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false

    //initialized variables
    private var currentWeight:Int = 65
    private var currentAge:Int = 25

    //declare components to initialize them and use them anywhere
    //gender
    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    //height
    private lateinit var tvHeight:TextView
    private lateinit var rsHeight:RangeSlider
    //weight
    private lateinit var tvWeight:TextView
    private lateinit var btnMinusWeight:FloatingActionButton
    private lateinit var btnPlusWeight:FloatingActionButton
    //Age
    private lateinit var tvAge:TextView
    private lateinit var btnMinusAge:FloatingActionButton
    private lateinit var btnPlusAge:FloatingActionButton

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

        tvWeight = findViewById(R.id.tvWeight)
        btnMinusWeight = findViewById(R.id.btnMinusWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)

        tvAge = findViewById(R.id.tvAge )
        btnMinusAge  = findViewById(R.id.btnMinusAge )
        btnPlusAge  = findViewById(R.id.btnPlusAge )

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

        //know when the slider moved, To change the height value
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            val result = df.format(value)
            tvHeight.text = result.toString()
        }

        //listeners to modify the value of the weight, each time the button is pressed the listener acts
        btnPlusWeight.setOnClickListener{
            currentWeight += 1
            setWeight()
        }
        btnMinusWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }

        //listeners to modify the value of the Age, each time the button is pressed the listener acts
        btnPlusAge.setOnClickListener{
            currentAge += 1
            setAge()
        }
        btnMinusAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
    }

    //shows the current age the graphic part
    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    //shows the current weight the graphic part
    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
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
        setWeight()
        setAge()
    }




}