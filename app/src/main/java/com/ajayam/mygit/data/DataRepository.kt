package com.ajayam.mygit.data

import com.ajayam.mygit.data.APIService

class DataRepository constructor(private val apiService: APIService) {
    suspend fun getRepoDetails(ownerName: String, repoName: String) =
        apiService.getRepoDetails(ownerName, repoName)
}