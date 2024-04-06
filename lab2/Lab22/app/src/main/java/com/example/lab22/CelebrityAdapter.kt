package com.example.lab22

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class CelebrityAdapter : RecyclerView.Adapter<CelebrityAdapter.CelebrityViewHolder>() {

    private var celebrityList = mutableListOf<Celebrity>()

    fun updateData(newList: List<Celebrity>) {
        val diffResult = DiffUtil.calculateDiff(CelebrityDiffCallback(celebrityList, newList))
        celebrityList.clear()
        celebrityList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CelebrityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_celebrity, parent, false)
        return CelebrityViewHolder(view)
    }

    override fun onBindViewHolder(holder: CelebrityViewHolder, position: Int) {
        holder.bind(celebrityList[position])
    }

    override fun getItemCount(): Int {
        return celebrityList.size
    }

    class CelebrityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val netWorthTextView: TextView = itemView.findViewById(R.id.netWorthTextView)
        private val genderTextView: TextView = itemView.findViewById(R.id.genderTextView)
        private val nationalityTextView: TextView = itemView.findViewById(R.id.nationalityTextView)
        private val heightTextView: TextView = itemView.findViewById(R.id.heightTextView)

        fun bind(celebrity: Celebrity) {
            nameTextView.text = "Name: ${celebrity.name}"
            netWorthTextView.text = "Net Worth: ${celebrity.netWorth}"
            genderTextView.text = "Gender: ${celebrity.gender}"
            nationalityTextView.text = "Nationality: ${celebrity.nationality}"
            heightTextView.text = "Height: ${celebrity.height}"
        }
    }

    class CelebrityDiffCallback(
        private val oldList: List<Celebrity>,
        private val newList: List<Celebrity>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}

