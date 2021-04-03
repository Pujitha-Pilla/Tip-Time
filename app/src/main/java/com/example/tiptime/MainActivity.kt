package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat


class MainActivity : AppCompatActivity() {
    lateinit var costOfService : EditText
    lateinit var service : RadioGroup
    lateinit var roundValue : SwitchCompat
    lateinit var calculate : Button
    lateinit var tipAmount : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        costOfService = findViewById(R.id.ed_costOfService)
        service = findViewById(R.id.rg_service)
        roundValue = findViewById(R.id.switch_round)
        calculate = findViewById(R.id.btn_calculate)
        tipAmount = findViewById(R.id.tv_tipAmount)

        calculate.setOnClickListener {

            val billAmount = costOfService.text.toString().toDouble()
            val tipPercent = when(service.checkedRadioButtonId){
                R.id.rb_amazingService -> 0.20
                R.id.rb_goodService -> 0.18
                else -> 0.15
            }
            val tip =  billAmount * tipPercent
            var tipAmt =  billAmount + tip
            if(roundValue.isChecked == true){
                tipAmt = kotlin.math.ceil(tipAmt)
            }
            else{
                tipAmt = String.format("%.2f",tipAmt).toDouble()
            }
            tipAmount.text = "Tip Amount: $"+ tipAmt
        }
    }
}