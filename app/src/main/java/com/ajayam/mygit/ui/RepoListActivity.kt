package com.ajayam.mygit.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ajayam.mygit.data.db.DatabaseHelper
import com.ajayam.mygit.databinding.ActivityMainBinding

class RepoListActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize()

    }

    //initializing instances
    private fun initialize() {
        databaseHelper = DatabaseHelper(this)
        binding.addNow.setOnClickListener(this)
        binding.addNewRepo.setOnClickListener(this)
        setAdapter()
    }

    //set data into recycle
    private fun setAdapter() {

        binding.mainRecycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val list = databaseHelper.getRepoList()
        if (list?.size!! > 0) {
            binding.mainRecycler.adapter = RepoAdapter(this, list)
        } else {
            binding.llAdd.visibility = View.VISIBLE
        }

    }

    //set action on button click
    override fun onClick(p0: View?) {
        when (p0) {
            binding.addNewRepo -> addNewActivity()

            binding.addNow -> addNewActivity()
        }
    }

    //redirecting to addRepoActivity
    private fun addNewActivity() {
        val intent = Intent(this, AddRepoActivity::class.java)
        startActivity(intent)
    }

}
