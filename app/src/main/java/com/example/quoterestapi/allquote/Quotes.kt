package com.example.quoterestapi.allquote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Quotes {
    @SerializedName("quote")
    @Expose
    var quote: List<Quote>? = null
}