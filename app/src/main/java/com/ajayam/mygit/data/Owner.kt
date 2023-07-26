package com.ajayam.mygit.data

import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("login") var login: String? = null,
    @SerializedName("id") var id: Int? = null
)
