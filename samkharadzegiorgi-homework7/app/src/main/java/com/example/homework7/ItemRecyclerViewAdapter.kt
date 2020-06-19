package com.example.homework7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recycler_view_layout.view.*

class ItemRecyclerViewAdapter (
    private val items: ArrayList<ItemModel>,
    private val activity: MainActivity
) :
    RecyclerView.Adapter<ItemRecyclerViewAdapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recycler_view_layout, parent,
                false
            )
        )
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        private lateinit var itemModel:ItemModel

        fun onBind(){

            itemModel = items[adapterPosition]

            Glide.with(activity).load(itemModel.cover)
                .into(itemView.imageView)

            itemView.titleTextView.text ="Title : "+itemModel.title
            itemView.descriptionTextView.text = "Description : "+itemModel.description

        }
    }


}