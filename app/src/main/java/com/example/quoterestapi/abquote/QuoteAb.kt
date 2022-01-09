package com.example.quoterestapi.abquote

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class QuoteAb {
    @SerializedName("quote")
    @Expose
    var quote: Quote? = null
}