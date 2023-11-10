package com.example.conversortemperatura

import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import com.example.conversortemperatura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonConvert.setOnClickListener {
            if (!binding.editCeucius.text.toString().isEmpty()) {
                val celsius = binding.editCeucius.text.toString().toDouble()
                val fahrenheit = String.format("%.2f", celsius * 1.8 + 32)

                binding.editResult.text = "ºF:$fahrenheit"
            } else {
                binding.editResult.text = "Valor inválido"
            }
        }

        binding.editCeucius.setOnKeyListener { view, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                // A tecla "Enter" foi pressionada, acionar o clique do botão
                binding.buttonConvert.performClick()

                return@setOnKeyListener true

            }

            return@setOnKeyListener false
        }
    }
}


