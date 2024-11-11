package com.example.dragonballgs.presentation.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dragonballgs.databinding.ActivityMainBinding
import com.example.dragonballgs.presentation.detail.DetailActivity
import com.example.dragonballgs.presentation.history.DragonBallHistoryActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btPesquisar.setOnClickListener {
            val idText = binding.etId.text.toString() // Converte o conteúdo para String
            val id = idText.toLongOrNull() // Tenta converter para Long, retornando null se falhar

            if (id != null) {
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("ID", id)
                startActivity(intent)
            } else {
                // Exibe uma mensagem de erro se a conversão falhar
                Toast.makeText(this, "Por favor, insira um ID válido", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btHistorico.setOnClickListener {
            val intent = Intent(this, DragonBallHistoryActivity::class.java)
           startActivity(intent)
        }
    }
}