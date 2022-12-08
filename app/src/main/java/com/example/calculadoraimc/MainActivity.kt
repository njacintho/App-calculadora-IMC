package com.example.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculadoraimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculo.setOnClickListener {

            val peso = binding.editPeso.text.toString().trim()
            val altura = binding.editAltura.text.toString().trim()



            if (peso.isEmpty() || altura.isEmpty()) {
                Toast.makeText(this,"Preencha todos os campos", Toast.LENGTH_LONG).show()


            }else{

                Toast.makeText(this, "Resultado", Toast.LENGTH_SHORT).show()


                val mIntent = Intent(this, ResultadoActivity::class.java)
                mIntent.putExtra("INTENT_ALTURA", altura)
                mIntent.putExtra("INTENT_PESO", peso)
                startActivity(mIntent)



            }
        }
    }
}