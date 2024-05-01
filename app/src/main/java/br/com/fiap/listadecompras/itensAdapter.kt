package br.com.fiap.listadecompras

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    // Define a lista de itens
    private val items = mutableListOf<ItemModel>()

    // Adiciona um novo item na lista
    fun addItem(newItem: ItemModel) {
        if (newItem.name.isBlank()) return
        items.add(newItem)
        notifyDataSetChanged()
    }

    // Limpa a lista de itens
    fun clearItems() {
        items.clear()
        notifyDataSetChanged()
    }

    // Cria um novo ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    // Retorna a quantidade de itens na lista
    override fun getItemCount(): Int = items.size

    // Define o conteúdo do item na posição informada
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // Recupera o item na posição informada
        val item = items[position]
        holder.bind(item)

        // Define a cor de fundo do item
        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.gray))
        } else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
        }

        // Define o comportamento do botão de deletar ao ser clicado
        holder.deleteButton.setOnClickListener {
            items.removeAt(position)
            notifyDataSetChanged()
        }
    }

    // Define o ViewHolder do item
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.textViewItem)
        val deleteButton = view.findViewById<Button>(R.id.deleteButton)
        fun bind(item: ItemModel) {
            textView.text = item.name
        }
    }
}