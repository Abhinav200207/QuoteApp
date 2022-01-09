package com.example.quoterestapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quoterestapi.randapi.RandomQuote
import com.example.quoterestapi.retrofitwork.RetrofitHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import android.content.Intent




class MainActivity : AppCompatActivity() {
    lateinit var randomQuote : RandomQuote
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadQuote()

    }

    private fun loadQuote(){
        CoroutineScope(Dispatchers.Default).launch {
            val result = RetrofitHelper.getInstance().getRandomQuote()
            val job1 = launch {
                randomQuote = result.body()!!
            }
            job1.join()
            val job2 = launch {
                CoroutineScope(Dispatchers.Main).launch {
                    name.text = randomQuote.randQuote?.name
                    text.text = randomQuote.randQuote?.text
                }
            }
        }
    }

    fun loadQuote(view: View) {
        loadQuote()
    }

    fun allQuotes(view: View) {
        val send = Intent(this@MainActivity, QuoteRecyclerView::class.java)
        startActivity(send)
    }

    fun postQuote(view: View) {
        val send = Intent(this@MainActivity, CreateQuote::class.java)
        startActivity(send)
    }
}

//class MainActivity : AppCompatActivity() {
//
//    lateinit var items: List<Item>
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        CoroutineScope(Dispatchers.Default).launch {
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
//            }
//        }
//    }
//}