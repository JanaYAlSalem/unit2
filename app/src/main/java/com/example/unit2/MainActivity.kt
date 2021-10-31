package com.example.unit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.unit2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var LinkXML: ActivityMainBinding // to initializes LinkXML in future time

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LinkXML = ActivityMainBinding.inflate(layoutInflater)  // initializes the binding object
        setContentView(LinkXML.root) // get root of XML

        LinkXML.buttonCalculate.setOnClickListener { calculateTip() } // call fun on button


    }

    private fun calculateTip() {
        val TextInput = LinkXML.InputNumber.text.toString() // the input of number in textV
        val result = TextInput.toDoubleOrNull()

        if (result == null) {
            LinkXML.ShowResult.text = ""
            return
        } // end What show in result if text input is NULL

        val PercentageOfTip = when (LinkXML.group.checkedRadioButtonId) {
            LinkXML.radioButtonAmazing.id -> 0.20
            LinkXML.radioButtonGood.id -> 0.18
            LinkXML.radioButtonOk.id -> 0.15
            else -> 1.0
        } // end when to get the Percentage Of Tip


        var ResultOfTip = result * PercentageOfTip

        if (LinkXML.SwitchTip.isChecked) {
            ResultOfTip = kotlin.math.ceil(ResultOfTip)
        } // calculate Tip with rounding

        //  val formattedTip = NumberFormat.getCurrencyInstance().format(ResultOfTip)
        LinkXML.ShowResult.setText(ResultOfTip.toString())

    } // end calculateTip fun


} // end Class