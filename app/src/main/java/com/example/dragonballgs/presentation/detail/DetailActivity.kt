package com.example.dragonballgs.presentation.detail

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.dragonballgs.R
import com.example.dragonballgs.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private val viewModel: DetalheViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recebe o id como Long, usando um valor padrão de -1 caso não esteja presente
        val id = intent.getLongExtra("ID", -1L)
        if (id != -1L) {
            viewModel.fetchDragon(id)
        } else {
            // Lida com o caso em que o ID não foi passado ou é inválido
            Toast.makeText(this, "ID inválido", Toast.LENGTH_SHORT).show()
            finish() // Opcional: encerra a Activity se o ID for inválido
        }

        viewModel.dragonData.observe(this, Observer { dragon ->
            binding.tvName.text = dragon.name


            // Carrega a imagem no ImageView usando Glide
            Glide.with(this)
                .load(dragon.images[0]) // Substitua `dragon.imageUrl` pelo nome correto do campo da URL da imagem
                .into(binding.dragonImage)
        })
    }
}
