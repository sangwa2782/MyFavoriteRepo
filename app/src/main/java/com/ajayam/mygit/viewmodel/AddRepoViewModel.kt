package com.ajayam.mygit.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ajayam.mygit.data.DataRepository
import com.ajayam.mygit.data.GitData
import com.google.gson.Gson
import kotlinx.coroutines.*

class AddRepoViewModel(application: Application, private val mainRepository: DataRepository) : AndroidViewModel(application) {
    val errorMessage = MutableLiveData<String>()
    val repoDetails = MutableLiveData<GitData>()
    val loading = MutableLiveData<Boolean>()

    var job: Job? = null

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    fun getRepoDetails(ownerName:String, repoName:String) {

        job = CoroutineScope(Dispatchers.IO ).launch {
            val response = mainRepository.getRepoDetails(ownerName,repoName)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    Log.e("onSuccess", Gson().toJson(response.body()) )
                    repoDetails.postValue(response.body())
                    loading.value = false
                } else {
                    Log.e("Error", Gson().toJson(response.message()) )
                    onError("Error : ${response.message()} ")
                }
            }
        }
    }

    //to print error
    private fun onError(message: String) {
        errorMessage.value = message
        Log.e("TAG", "onCoroutineError: "+message )
        loading.value = false
    }

    //clear job
    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}