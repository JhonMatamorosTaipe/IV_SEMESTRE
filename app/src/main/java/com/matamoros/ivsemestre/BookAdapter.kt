package com.matamoros.ivsemestre

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.matamoros.ivsemestre.databinding.ItemBookBinding

class BookAdapter(private val books: List<Book>)
    : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(val binding: ItemBookBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.binding.txtTitle.text = book.title
        holder.binding.txtAuthor.text = book.author
        holder.binding.txtDescription.text = book.description

        Glide.with(holder.itemView.context)
            .load(book.coverPath)
            .placeholder(android.R.drawable.ic_menu_report_image)
            .into(holder.binding.imgCover)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, BookDetailActivity::class.java)
            intent.putExtra("pdfPath", book.pdfPath)
            intent.putExtra("title", book.title)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = books.size
}