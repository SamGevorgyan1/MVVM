package com.architecturemvvm.ui.news.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.architecturemvvm.databinding.NewsAdapterBinding
import com.guardian.model.news.NewsResultDto


class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var items:MutableList<NewsResultDto> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = NewsAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: List<NewsResultDto>?){
        this.items.clear()
       items?.let { this.items.addAll(it) }
        notifyDataSetChanged()
    }

    inner class NewsViewHolder(private var binding:NewsAdapterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NewsResultDto) {
            binding.webTitle.text = item.webTitle
            binding.sectionName.text = item.sectionName
            binding.date.text = item.webPublicationDate
        }
    }

}