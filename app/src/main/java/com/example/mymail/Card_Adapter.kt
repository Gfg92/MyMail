package com.example.mymail

import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView

class Card_Adapter(var items: ArrayList<Card>) :
    RecyclerView.Adapter<Card_Adapter.TarjViewHolder>(){
    lateinit var onClick: (View) -> Unit
    lateinit var onLongClick : (View) -> Unit
    init {
        this.items = items
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnCreateContextMenuListener  {

        private var imagen: ImageView
        private var titulo: TextView




        init {
            imagen = itemView.findViewById(R.id.imagen_imageView)
            titulo = itemView.findViewById(R.id.titulo_carta)
            itemView.setOnCreateContextMenuListener(this)

        }

        fun bindTarjeta(t: Card, onLongClick: (View) -> Unit) = with(itemView) {
            imagen.setImageResource(t.imagen)
            titulo.setText(t.titulo)

            setOnLongClickListener { onLongClick(itemView)
                true }
        }

        override fun onCreateContextMenu(contextMenu: ContextMenu, view: View, contextMenuInfo: ContextMenu.ContextMenuInfo?) {
            contextMenu.add(0, 0, adapterPosition, "Editar")     //groupId, itemId, order, title
            contextMenu.add(0, 1, adapterPosition, "Eliminar")
            contextMenu.add(0, 2, adapterPosition, "Compartir")
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.card_item, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindTarjeta(item, onClick)

        viewHolder.bindTarjeta(item, onLongClick)


    }

    override fun getItemCount(): Int {
        return items.size
    }

}