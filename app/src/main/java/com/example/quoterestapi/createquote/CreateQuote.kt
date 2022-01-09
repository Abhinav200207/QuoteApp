package com.example.quoterestapi.createquote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CreateQuoteab(
    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("text")
    @Expose
    var text: String? = null
)
