package com.example.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadoraimc.databinding.ActivityBoaVindasBinding

class BoaVindasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBoaVindasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boa_vindas)

        binding = ActivityBoaVindasBinding.inflate(layoutInflater)//método em inflate
        setContentView(binding.root) //encaminha através do binding

        binding.btnCalcule.setOnClickListener {
            val mIntent = Intent(this, MainActivity::class.java)
            startActivity(mIntent)
        }
    }
}