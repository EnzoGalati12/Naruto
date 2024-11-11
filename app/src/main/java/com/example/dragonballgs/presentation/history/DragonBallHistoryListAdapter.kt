package com.example.dragonballgs.presentation.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dragonballgs.databinding.DragonHistoryItemBinding
import com.example.dragonballgs.domain.model.DragonBall


class DragonBallHistoryListAdapter(
    private val onDeleteClick: (DragonBall) -> Unit
) : RecyclerView.Adapter<DragonBallHistoryListAdapter.DragonBallViewHolder>() {

    private var dragons: List<DragonBall> = emptyList()

    class DragonBallViewHolder(val binding: DragonHistoryItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragonBallViewHolder {
        val binding = DragonHistoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DragonBallViewHolder(binding)
    }


    override fun onBindViewHolder(holder: DragonBallViewHolder, position: Int) {
        val currentDragon = dragons[position]

        holder.binding.tvLinha1.text = "${currentDragon.name}"


        // Load image with Glide
        Glide.with(holder.itemView.context)
            .load(currentDragon.images[0]) // Replace `imageUrl` with the correct field from your `DragonBall` class
            .into(holder.binding.dragonImage) // Replace `dragonImage` with the ID of your ImageView


        holder.binding.icDelete.setOnClickListener { onDeleteClick(currentDragon) }
    }

    override fun getItemCount() = dragons.size

    fun setCeps(dragons: List<DragonBall>) {
        this.dragons = dragons
        notifyDataSetChanged()
    }
}
