package com.example.calculator

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.Button
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    var lastNumeric = false

    var stateError = false

    var lastDot = false

    private lateinit var expression: Expression

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onEqualClick(view: View) {}


    fun onDigitClick(view: View) {

        if(stateError){

            binding.dataTv.text = (view as Button).text
        }else {
            binding.dataTv.append((view as Button).text)
        }

        lastNumeric = true
        onEqual()


    }


    fun onAllclearClick(view: View) {

        binding.dataTv.text = ""
        binding.resultTv.text = ""
        stateError = false
        lastDot = false
        lastNumeric = false
        binding.resultTv.visibility = View.GONE

    }


    fun onOperatorClick(view: View) {}


    fun onClearClick(view: View) {}


    fun onBackClick(view: View) {}

    fun onEqual(){

        if (lastNumeric && !stateError){

            val txt = binding.dataTv.text.toString()

            expression = ExpressionBuilder(txt).build()

            try {
                val result = expression.evaluate()

                binding.resultTv.visibility = View.VISIBLE

                binding.resultTv.text = "=" + result.toString()
            }catch (ex : ArithmeticException){

                Log.e("evaluate error" , ex.toString())
                binding.resultTv.text = "Error"
                stateError = true
                lastNumeric = false
            }

        }
    }

}