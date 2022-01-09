package com.example.quoterestapi.randapi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class RandomQuote {
    @SerializedName("randQuote")
    @Expose
    var randQuote: RandQuote? = null
}