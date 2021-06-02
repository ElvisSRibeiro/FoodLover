package com.example.foodlover.entity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodlover.R
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class MyAdapter(options: FirestoreRecyclerOptions<ItemModel>) :
    FirestoreRecyclerAdapter<ItemModel, MyAdapter.MyViewHolder>(options) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent,false)
        return MyViewHolder(itemView)


    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int, model: ItemModel) {
        holder.cardnome.text = model.nome
        holder.cardavaliacao.text = model.avaliacao
        holder.carddescricao.text = model.descricao
    }

    class  MyViewHolder(itemView: View) :RecyclerView.ViewHolder (itemView){

        val cardnome : TextView = itemView.findViewById(R.id.card_nome)
        val cardavaliacao : TextView = itemView.findViewById(R.id.card_avaliacao)
        val carddescricao : TextView = itemView.findViewById(R.id.card_descricao)


    }

}