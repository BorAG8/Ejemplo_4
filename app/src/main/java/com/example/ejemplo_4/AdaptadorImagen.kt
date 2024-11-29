package com.example.ejemplo_4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorImagen(var items: ArrayList<Imagen>) : RecyclerView.Adapter<AdaptadorImagen.TarjViewHolder>() {

    lateinit var onClick: (View) -> Unit

    init {
        this.items = items
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imag : ImageView

        init {
            imag = itemView.findViewById(R.id.fotito)
        }

        fun bindTarjeta(t: Imagen, onClick: (View) -> Unit) = with(itemView) {
            imag.setImageResource(t.foto)
            setOnClickListener{ onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindTarjeta(item,onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}