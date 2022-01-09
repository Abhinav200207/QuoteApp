package com.example.quoterestapi.retrofitwork

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    const val BASE_URL = "https://quote-app-apiab.herokuapp.com"
    fun getInstance() : ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }

}

//object RetrofitHelper {
//    const val BASE_URL = "https://www.googleapis.com/books/"
//    fun getInstance() : ApiService {
//        val retrofit =  Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        return retrofit.create(ApiService::class.java)
//    }
//}