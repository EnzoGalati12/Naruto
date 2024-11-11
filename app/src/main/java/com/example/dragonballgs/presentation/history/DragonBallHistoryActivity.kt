package com.example.dragonballgs.presentation.history

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dragonballgs.R
import com.example.dragonballgs.databinding.ActivityDragonBallHistoryBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DragonBallHistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDragonBallHistoryBinding

    private val viewModel: DragonBallViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDragonBallHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getHistory()

        viewModel.dragonAllHistory.observe(this) {
            val adapter = DragonBallHistoryListAdapter(onDeleteClick = {
                viewModel.delete(it.id)
            })
            binding.rvHistory.adapter = adapter
            binding.rvHistory.layoutManager = LinearLayoutManager(this)
            adapter.setCeps(it)
        }

        binding.btDeleteAll.setOnClickListener {
            viewModel.deleteAll()
            viewModel.getHistory()

        }
    }
}