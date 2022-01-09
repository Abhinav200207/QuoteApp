package com.example.quoterestapi.retrofitwork

import com.example.quoterestapi.CreateQuote
import com.example.quoterestapi.abquote.QuoteAb
import com.example.quoterestapi.allquote.Quotes
import com.example.quoterestapi.createquote.CreateQuoteab
import com.example.quoterestapi.randapi.RandomQuote
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("/api/v1/random/randomgen")
    suspend fun getRandomQuote() : Response<RandomQuote>

    @GET("/api/v1/random/")
    suspend fun getAllQuotes() : Response<Quotes>

    @POST("/api/v1/random/")
    suspend fun createQuote(@Body post : CreateQuoteab ) : Response<QuoteAb>
}

//https://quote-app-apiab.herokuapp.com/api/v1/random/