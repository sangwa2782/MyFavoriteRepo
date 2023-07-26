package com.ajayam.mygit.util

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ajayam.mygit.data.DataRepository
import com.ajayam.mygit.viewmodel.AddRepoViewModel

class ViewModelFactory constructor(private val application: Application, private val repository: DataRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(AddRepoViewModel::class.java)) {
            AddRepoViewModel(this.application,this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}