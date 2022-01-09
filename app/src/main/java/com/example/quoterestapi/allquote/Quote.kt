package com.example.quoterestapi.allquote

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Quote {
    @SerializedName("_id")
    @Expose
    var id: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("text")
    @Expose
    var text: String? = null

    @SerializedName("__v")
    @Expose
    var v: Int? = null
}