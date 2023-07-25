package com.ajayam.mygit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ajayam.mygit.databinding.ActivityAddNewRepoBinding
import com.ajayam.mygit.databinding.ActivityMainBinding

class AddNewRepo : AppCompatActivity() {

    private lateinit var binding: ActivityAddNewRepoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewRepoBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_add_new_repo)

        binding.goFirstActivity.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }




    }
}