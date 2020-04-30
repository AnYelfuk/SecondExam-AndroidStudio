package com.example.partialhero

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.partialhero.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //inflation
        // create binding object from activity main.xml
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.guessButton.setOnClickListener { guessHero() }
    }
    private fun guessHero() {

        binding.apply {
            val nameGuessSuperHero : EditText = binding.nickNameHero
            val cluetext : TextView = binding.clueTextView
            val variable = nameGuessSuperHero.getText().toString()
            cluetext.text = variable
            cluetext.setVisibility(View.VISIBLE)
            if (variable == ""){
                cluetext.text = "Venga tu puedes!"
                cluetext.setTextColor(Color.RED)
            }else if (variable == "wolverine"){
                cluetext.text = "Correcto!"
                cluetext.setTextColor(Color.GREEN)
            }else{
                cluetext.text = "Recuerda que es un mutante"
                cluetext.setTextColor(Color.BLUE)
            }
        }
    }
}
