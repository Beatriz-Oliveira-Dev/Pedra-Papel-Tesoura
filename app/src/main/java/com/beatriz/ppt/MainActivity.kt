package com.beatriz.ppt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun selecionarPedra(view : View) {
        opcaoSelecionada("pedra")
    }

    fun selecionarPapel(view : View) {
        opcaoSelecionada("papel")
    }

    fun selecionarTesoura(view : View) {
        opcaoSelecionada("tesoura")
    }

    fun opcaoSelecionada(opcaoSelecionada : String){
        var imageResultado : ImageView = findViewById(R.id.opcaoComputador)
        var textoResultado : TextView = findViewById(R.id.textResultado)
        var numero : Int = Random().nextInt(3)
        var opcoes = arrayListOf("pedra", "papel", "tesoura")
        var opcaoApp = opcoes.get(numero)

        when (opcaoApp){
            "pedra" -> imageResultado.setImageResource(R.mipmap.ic_pedra_foreground)
            "papel" -> imageResultado.setImageResource(R.mipmap.ic_papel_foreground)
            "tesoura" -> imageResultado.setImageResource(R.mipmap.ic_tesoura_foreground)
        }

        if (
            (opcaoApp == "tesoura" && opcaoSelecionada == "papel") ||
            (opcaoApp == "papel" && opcaoSelecionada == "pedra") ||
            (opcaoApp == "pedra" && opcaoSelecionada == "tesoura")
        ){//APP GANHADOR
            textoResultado.setText("Você perdeu!")
        }else if(
            (opcaoSelecionada == "tesoura" && opcaoApp == "papel") ||
            (opcaoSelecionada == "papel" && opcaoApp == "pedra") ||
            (opcaoSelecionada == "pedra" && opcaoApp == "tesoura")
        ){//USUARIO GANHADOR
            textoResultado.setText("Você ganhou!")

        }else{
            textoResultado.setText("Empatamos!")
        }

    }
}