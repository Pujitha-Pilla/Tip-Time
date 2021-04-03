package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import com.example.tiptime.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var costOfService : EditText
    lateinit var service : RadioGroup
    lateinit var roundValue : SwitchCompat
    lateinit var calculate : Button
    lateinit var tipAmount : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        costOfService = binding.edCostOfService
        service = binding.rgService
        roundValue = binding.switchRound
        calculate = binding.btnCalculate
        tipAmount = binding.tvTipAmount

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