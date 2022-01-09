package com.example.quoterestapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quoterestapi.abadapter.MyAdapter
import com.example.quoterestapi.allquote.Quote
import com.example.quoterestapi.retrofitwork.RetrofitHelper
import kotlinx.android.synthetic.main.activity_quote_recycler_view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteRecyclerView : AppCompatActivity() {
    lateinit var quotes: List<Quote>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote_recycler_view)
        getQuotes()
    }

    private fun getQuotes() {
        CoroutineScope(Dispatchers.Default).launch {
            val result = RetrofitHelper.getInstance().getAllQuotes()
            val job1 = launch {
                quotes = result.body()!!.quote!!
            }
            job1.join()

            val job2 = launch {
                CoroutineScope(Dispatchers.Main).launch {
                    recyclerview.layoutManager = LinearLayoutManager(this@QuoteRecyclerView)
                    recyclerview.adapter = MyAdapter(this@QuoteRecyclerView,quotes)
                }
            }
        }
    }
}