package com.example.food.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.food.databinding.RowCategoryBinding
import com.example.food.model.Category

class CategoryAdapter: RecyclerView.Adapter<CategoryViewHolder>() {

    var categorys = mutableListOf<Category>()

    fun setCategoryList(categorys: List<Category>) {
        this.categorys = categorys.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = RowCategoryBinding.inflate(inflater, parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categorys[position]
        holder.binding.name.text=categorys[position]
        Glide.with(holder.itemView.context).load(category.imageUrl).into(holder.binding.imageview)

    }

    override fun getItemCount(): Int {
        return categorys.size
    }


}
class CategoryViewHolder(binding: RowCategoryBinding) :RecyclerView.ViewHolder(binding.root){

}
