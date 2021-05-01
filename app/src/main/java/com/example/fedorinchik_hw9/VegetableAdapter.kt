package com.example.fedorinchik_hw9

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VegetableAdapter(
    private val vegetables: List<Data>, private val onClick: (Data) -> Unit
) :
    RecyclerView.Adapter<VegetableAdapter.ViewHolderCurrentVegetable>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCurrentVegetable {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.vegetable_fragment, parent, false)
        return ViewHolderCurrentVegetable(view, onClick)
    }

    override fun getItemCount(): Int {
        return vegetables.size
    }

    override fun onBindViewHolder(holder: ViewHolderCurrentVegetable, pos: Int) {
        holder.bindViewHolder(vegetables[pos])
    }

    class ViewHolderCurrentVegetable(view: View, val onClick: (Data) -> Unit) :
        RecyclerView.ViewHolder(view) {
        private var currentViewHolder: Data? = null
        private val image = view.findViewById<ImageView>(R.id.vegetable_img)
        private val vegetableName = view.findViewById<TextView>(R.id.veg_name)
        private val vegetableOption = view.findViewById<TextView>(R.id.veg_option)

        init {
            view.setOnClickListener {
                currentViewHolder?.let {
                    onClick(it)
                }
            }
        }

        fun bindViewHolder(currentVegetable: Data) {
            currentViewHolder = currentVegetable
            image.setBackgroundResource(currentVegetable.vegetableImg)
            vegetableName.text = currentVegetable.vegetableName
            vegetableOption.text = currentVegetable.vegetableOption
        }
    }
}