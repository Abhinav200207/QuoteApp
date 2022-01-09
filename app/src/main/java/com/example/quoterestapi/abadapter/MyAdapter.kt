package com.example.quoterestapi.abadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quoterestapi.R
import com.example.quoterestapi.allquote.Quote

class MyAdapter(val context: Context, private val quotes: List<Quote>) : RecyclerView.Adapter<MyAdapter.QuoteViewAdapter>(){
    class QuoteViewAdapter(itemView: View) : RecyclerView.ViewHolder(itemView){
        var name = itemView.findViewById<TextView>(R.id.name1)
        var text = itemView.findViewById<TextView>(R.id.content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewAdapter {
        return QuoteViewAdapter(LayoutInflater.from(context).inflate(R.layout.quotelist,parent,false))
    }

    override fun onBindViewHolder(holder: QuoteViewAdapter, position: Int) {
        val quote = quotes[position]
        holder.name.text = quote.name.toString()
        holder.text.text = quote.text.toString()
    }

    override fun getItemCount(): Int {
        return quotes.size
    }
}

//class BookAdapter(val context: Context, private val items : List<Item>) : RecyclerView.Adapter<BookAdapter.BooksViewAdapter>(){
//    class BooksViewAdapter(itemView : View) : RecyclerView.ViewHolder(itemView) {
//        var selfLink = itemView.findViewById<TextView>(R.id.textView)
//        var title = itemView.findViewById<TextView>(R.id.textView2)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewAdapter {
//        return BooksViewAdapter(LayoutInflater.from(context).inflate(R.layout.books,parent,false))
//    }
//
//    override fun onBindViewHolder(holder: BooksViewAdapter, position: Int) {
//        val item = items[position]
//        holder.selfLink.text = item.kind.toString()
//        holder.title.text = item.volumeInfo?.title.toString()
//    }
//
//    override fun getItemCount(): Int {
//        return items.size
//    }
//}