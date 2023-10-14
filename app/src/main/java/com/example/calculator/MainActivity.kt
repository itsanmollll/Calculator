package com.example.calculator

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    var lastNumeric = false

    var stateError = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onEqualClick(view: View) {}


    fun onDigitClick(view: View) {}


    fun onAllclearClick(view: View) {}


    fun onOperatorClick(view: View) {}


    fun onClearClick(view: View) {}


    fun onBackClick(view: View) {}


}