package com.example.quoterestapi.abquote

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Quote {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("text")
    @Expose
    var text: String? = null

    @SerializedName("_id")
    @Expose
    var id: String? = null

    @SerializedName("__v")
    @Expose
    var v: Int? = null
}