package com.ajayam.mygit.ui

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ajayam.mygit.data.APIService
import com.ajayam.mygit.data.DataRepository
import com.ajayam.mygit.data.RepoData
import com.ajayam.mygit.data.db.DatabaseHelper
import com.ajayam.mygit.databinding.ActivityAddNewRepoBinding
import com.ajayam.mygit.util.ViewModelFactory
import com.ajayam.mygit.viewmodel.AddRepoViewModel
import com.google.gson.Gson

class AddRepoActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityAddNewRepoBinding
    private lateinit var viewModel: AddRepoViewModel
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewRepoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialize()
    }

    //initializing instances
    private fun initialize() {

        binding.submit.setOnClickListener(this)
        binding.ivBack.setOnClickListener(this)
        databaseHelper = DatabaseHelper(this)

        val retrofitService = APIService.getInstance()
        val dataRepository = DataRepository(retrofitService)
        viewModel = ViewModelProvider(this, ViewModelFactory(Application(), dataRepository)).get(
            AddRepoViewModel::class.java
        )
    }

    //set action on button click
    override fun onClick(p0: View?) {
        when (p0) {
            binding.submit -> {
                if (isValidInput()) {
                    getRepoDetails()
                } else {
                    Toast.makeText(this, "Enter valid credential", Toast.LENGTH_SHORT).show()
                }
            }

            binding.ivBack -> {
                onBackPressed()
            }
        }
    }

    //checking field validation
    private fun isValidInput(): Boolean {

        if (!TextUtils.isEmpty(binding.repoOwnerName.text.toString())
            && !TextUtils.isEmpty(binding.repoName.text.toString())
        ) {
            return true
        }
        return false
    }

    //observing view model
    private fun getRepoDetails() {

        viewModel.repoDetails.observe(this) {
            Toast.makeText(this, "Data added successfully", Toast.LENGTH_SHORT).show()
            Log.e("TAG", "getRepoData: " + Gson().toJson(it))
            val repoData = RepoData(
                it.owner?.login.toString(),
                it.name.toString(),
                it.htmlUrl.toString(),
                it.description.toString()
            )

            //saving data in db
            databaseHelper.saveRepoData(repoData)

        }

        //observing errors
        viewModel.errorMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            Log.e("TAG", "errorMessage: " + Gson().toJson(it))
        }

        //observing process
        viewModel.loading.observe(this, Observer {

        })

        //get repository data
        viewModel.getRepoDetails(
            binding.repoOwnerName.text.toString(),
            binding.repoName.text.toString()
        )
    }

    override fun onBackPressed() {
        val intent = Intent(this, RepoListActivity::class.java)
        startActivity(intent)
    }
}