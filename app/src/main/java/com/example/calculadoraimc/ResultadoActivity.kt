package com.example.calculadoraimc

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.calculadoraimc.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultadoBinding

    private fun calcImc(peso: Float, altura: Float): Float {
        return (peso / (altura * altura))

    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val peso =  intent.getStringExtra("INTENT_PESO").toString().toFloat()
        val altura = intent.getStringExtra("INTENT_ALTURA").toString().toFloat()


        binding.textImc.text ="Seu IMC é %.1f".format (calcImc(peso, altura))



            if (calcImc (peso, altura).toString().toFloat()< 18.5.toFloat()) {
                binding.textmed.text = "Seu IMC é menor que 18.5"
                binding.textTipo.text = "Você está abaixo do Peso"

            } else if (calcImc (peso, altura).toString().toFloat() >= 18.5.toFloat() && calcImc (peso, altura).toString().toFloat() <= 24.9.toFloat()) {
                binding.textmed.text = "Seu IMC está entre 18,5 e 24,9"
                binding.textTipo.text = "Você está com peso normal"
            } else if (calcImc (peso, altura).toString().toFloat() >= 25.toFloat() && calcImc (peso, altura).toString().toFloat() <= 29.9.toFloat()) {
                binding.textmed.text = "Seu IMC está entre 25 e 29,9"
                binding.textTipo.text = "Você está com sobrepeso"
            }else if (calcImc (peso, altura).toString().toFloat() >= 30.toFloat() && calcImc (peso, altura).toString().toFloat() <= 39.9.toFloat()) {
                binding.textmed.text = "Seu IMC está entre 30 e 39,9 "
                binding.textTipo.text = "Você está com obesidade"
            }else{
                binding.textmed.text = "Seu IMC está maior ou igual 40"
                binding.textTipo.text = "Você está comm obesidade grave"
            }

        binding.btnsair.setOnClickListener {

            //Criar uma caixa de dialogo
            val alert = AlertDialog.Builder(this)
            //Definindo o título da caixa de diálogo
            alert.setTitle("Atenção!")
            // definimos o Corpo da mensagem
            alert.setMessage("Deseja mesmo Sair?")
            //Definindo o rótulo do botão e escutando o seu clique
            alert.setPositiveButton("Sair"){ dialog, which ->
                val mIntent = Intent(this, BoaVindasActivity::class.java)
                startActivity(mIntent)
                //Eliminando a tela da pilha
                finishAffinity()
            }
            //botão Não
            alert.setNeutralButton("Não"){dialog,which ->}
            //botão Sair
            alert.setCancelable(false)
            // desabilita a possibilidade do usuário cancelar clicando fora da caixa
            alert.show()
        }

        binding.btnMAin.setOnClickListener {
            // executando o clique de voltar para pagina MAin
            val mIntent = Intent(this, MainActivity::class.java)
            startActivity(mIntent)
        }

    }
}



