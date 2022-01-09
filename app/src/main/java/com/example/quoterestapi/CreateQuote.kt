package com.example.quoterestapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.quoterestapi.abquote.QuoteAb
import com.example.quoterestapi.allquote.Quote
import com.example.quoterestapi.allquote.Quotes
import com.example.quoterestapi.createquote.CreateQuoteab
import com.example.quoterestapi.retrofitwork.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateQuote : AppCompatActivity() {
    lateinit var name : TextView
    lateinit var content : TextView
    lateinit var quote: CreateQuoteab
    lateinit var quotes: QuoteAb
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_quote)
    }

    private fun createQuote(name : String, content : String){
        quote = CreateQuoteab(name,content)
        CoroutineScope(Dispatchers.Default).launch {
            val result = RetrofitHelper.getInstance().createQuote(quote)
            val job1 = launch {
                quotes = result.body()!!
            }
            job1.join()
//            Toast.makeText(this@CreateQuote,"${quotes.quote?.id}",Toast.LENGTH_LONG)
        }
    }

    fun createQuotes(view: View) {
        name = findViewById(R.id.editTextTextPersonName)
        content = findViewById(R.id.editTextTextPersonName2)
        createQuote(name.text.toString(),content.text.toString())
    }
}

//      CoroutineScope(Dispatchers.Default).launch {
//            val result = RetrofitHelper.getInstance().getBooks("python")
//            val job1 = launch {
//                items = result.body()!!.items!!
//                Log.d("Bobby", result.body()!!.items?.get(0)?.kind.toString())
//            }
//            job1.join()
//
//            val job2 = launch {
//                CoroutineScope(Dispatchers.Main).launch {
//                    rView.layoutManager = LinearLayoutManager(this@MainActivity)
//                    rView.adapter = BookAdapter(this@MainActivity, items)
//                }