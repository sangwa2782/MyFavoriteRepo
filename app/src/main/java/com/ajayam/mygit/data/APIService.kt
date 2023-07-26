package com.ajayam.mygit.data

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("/repos/{owner}/{repo}")
    suspend fun getRepoDetails(
        @Path("owner") ownerName: String,
        @Path("repo") repoName: String
    ): Response<GitData>


    companion object {
        var retrofitService: APIService? = null

        fun getInstance(): APIService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.github.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(APIService::class.java)
            }
            return retrofitService!!
        }
    }
}


