package com.example.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
      private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ButtonCalculate.setOnClickListener{
            calculate()
        }

    }

    private fun calculate(){

        if (validate()) {

            val distance = binding.EditTextKm.text.toString().toFloat()
            val price = binding.EditTextPrice.text.toString().toFloat()
            val autonomy = binding.EditTextAutonomy.text.toString().toFloat()
            val totalValue = (distance * price) / autonomy

            binding.TextViewValue.text = "R$ ${"%.2f"}".format(totalValue)

        } else {

            Toast.makeText(this,R.string.validate_fields,Toast.LENGTH_SHORT).show()
        }

    }

    private fun validate() : Boolean{
        return (binding.EditTextKm.text.toString() !=""
                && binding.EditTextPrice.text.toString() != ""
                && binding.EditTextAutonomy.text.toString() != ""
                && binding.EditTextAutonomy.text.toString().toFloat() != 0f)
    }
}