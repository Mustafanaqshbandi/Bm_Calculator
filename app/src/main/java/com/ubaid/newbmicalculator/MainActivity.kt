package com.ubaid.newbmicalculator

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ubaid.newbmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.Wheightpikker.minValue = 30
        binding.Wheightpikker.maxValue = 150


        binding.Heightpikkert.minValue = 100
        binding.Heightpikkert.maxValue = 250

        binding.Wheightpikker.setOnValueChangedListener{ _,_,_->
            calculateBMI()

        }

        binding.Heightpikkert.setOnValueChangedListener{ _,_,_->
            calculateBMI()

        }



    }
    private fun calculateBMI()
    {
        val height=binding.Heightpikkert.value
        val doubleHeight=height.toDouble() / 100
        val wheight=binding.Wheightpikker.value
        val bmi=wheight.toDouble() / (doubleHeight * doubleHeight)
        binding.Resultstv.text=String.format("you BMI is: %.2f",bmi)
        binding.HealthyTV.text=String.format("Considered: %s",healthyMessage(bmi))
        
    }

    private fun healthyMessage(bmi: Double): String {
if (bmi < 18.5)
    return "underweight"
        if (bmi < 25.0)
            return "healthy"
        if (bmi < 30.0)
            return "overweight"
        return "Obese"
    }

}