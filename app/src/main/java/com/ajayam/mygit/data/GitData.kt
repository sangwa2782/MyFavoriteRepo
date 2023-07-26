package com.ajayam.mygit.data

import com.google.gson.annotations.SerializedName

data class GitData(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("owner") var owner: Owner? = Owner(),
    @SerializedName("html_url") var htmlUrl: String? = null,
    @SerializedName("description") var description: String? = null
)
