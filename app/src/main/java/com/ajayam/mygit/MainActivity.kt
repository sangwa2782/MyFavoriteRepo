package com.ajayam.mygit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.ajayam.mygit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    var listDetails = arrayListOf<GitLIstClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        listDetails = ArrayList<GitLIstClass>()

        listDetails.add(GitLIstClass("MyGit one", "At this point, the ellipsis will not display yet as a TextView is set to automatically expand on default when new text is entered. You will need to limit the TextView in some way. Do do this, you can use either add to your TextView a scrollHorizontally, minLines, or maxLines to have the ellipsis display."))
        listDetails.add(GitLIstClass("MyGit two", "At this point, the ellipsis will not display yet as a TextView is set to automatically expand on default when new text is entered. You will need to limit the TextView in some way. Do do this, you can use either add to your TextView a scrollHorizontally, minLines, or maxLines to have the ellipsis display."))
        listDetails.add(GitLIstClass("MyGit three", "At this point, the ellipsis will not display yet as a TextView is set to automatically expand on default when new text is entered. You will need to limit the TextView in some way. Do do this, you can use either add to your TextView a scrollHorizontally, minLines, or maxLines to have the ellipsis display."))
        listDetails.add(GitLIstClass("MyGit four", "At this point, the ellipsis will not display yet as a TextView is set to automatically expand on default when new text is entered. You will need to limit the TextView in some way. Do do this, you can use either add to your TextView a scrollHorizontally, minLines, or maxLines to have the ellipsis display."))
        listDetails.add(GitLIstClass("MyGit five", "At this point, the ellipsis will not display yet as a TextView is set to automatically expand on default when new text is entered. You will need to limit the TextView in some way. Do do this, you can use either add to your TextView a scrollHorizontally, minLines, or maxLines to have the ellipsis display."))
        listDetails.add(GitLIstClass("MyGit six", "At this point, the ellipsis will not display yet as a TextView is set to automatically expand on default when new text is entered. You will need to limit the TextView in some way. Do do this, you can use either add to your TextView a scrollHorizontally, minLines, or maxLines to have the ellipsis display."))
        listDetails.add(GitLIstClass("MyGit seven", "At this point, the ellipsis will not display yet as a TextView is set to automatically expand on default when new text is entered. You will need to limit the TextView in some way. Do do this, you can use either add to your TextView a scrollHorizontally, minLines, or maxLines to have the ellipsis display."))
        listDetails.add(GitLIstClass("MyGit eight", "At this point, the ellipsis will not display yet as a TextView is set to automatically expand on default when new text is entered. You will need to limit the TextView in some way. Do do this, you can use either add to your TextView a scrollHorizontally, minLines, or maxLines to have the ellipsis display."))
        listDetails.add(GitLIstClass("MyGit nine", "At this point, the ellipsis will not display yet as a TextView is set to automatically expand on default when new text is entered. You will need to limit the TextView in some way. Do do this, you can use either add to your TextView a scrollHorizontally, minLines, or maxLines to have the ellipsis display."))
        listDetails.add(GitLIstClass("MyGit ten", "At this point, the ellipsis will not display yet as a TextView is set to automatically expand on default when new text is entered. You will need to limit the TextView in some way. Do do this, you can use either add to your TextView a scrollHorizontally, minLines, or maxLines to have the ellipsis display."))
        listDetails.add(GitLIstClass("MyGit eleven", "At this point, the ellipsis will not display yet as a TextView is set to automatically expand on default when new text is entered. You will need to limit the TextView in some way. Do do this, you can use either add to your TextView a scrollHorizontally, minLines, or maxLines to have the ellipsis display."))
        listDetails.add(GitLIstClass("MyGit twelve", "At this point, the ellipsis will not display yet as a TextView is set to automatically expand on default when new text is entered. You will need to limit the TextView in some way. Do do this, you can use either add to your TextView a scrollHorizontally, minLines, or maxLines to have the ellipsis display."))
        listDetails.add(GitLIstClass("MyGit thirteen", "At this point, the ellipsis will not display yet as a TextView is set to automatically expand on default when new text is entered. You will need to limit the TextView in some way. Do do this, you can use either add to your TextView a scrollHorizontally, minLines, or maxLines to have the ellipsis display."))
        listDetails.add(GitLIstClass("MyGit fourteen", "At this point, the ellipsis will not display yet as a TextView is set to automatically expand on default when new text is entered. You will need to limit the TextView in some way. Do do this, you can use either add to your TextView a scrollHorizontally, minLines, or maxLines to have the ellipsis display."))
        listDetails.add(GitLIstClass("MyGit fifteen", "At this point, the ellipsis will not display yet as a TextView is set to automatically expand on default when new text is entered. You will need to limit the TextView in some way. Do do this, you can use either add to your TextView a scrollHorizontally, minLines, or maxLines to have the ellipsis display."))
        listDetails.add(GitLIstClass("MyGit sixteen", "At this point, the ellipsis will not display yet as a TextView is set to automatically expand on default when new text is entered. You will need to limit the TextView in some way. Do do this, you can use either add to your TextView a scrollHorizontally, minLines, or maxLines to have the ellipsis display."))
        listDetails.add(GitLIstClass("MyGit seventeen", "At this point, the ellipsis will not display yet as a TextView is set to automatically expand on default when new text is entered. You will need to limit the TextView in some way. Do do this, you can use either add to your TextView a scrollHorizontally, minLines, or maxLines to have the ellipsis display."))
        listDetails.add(GitLIstClass("MyGit eighteen", "At this point, the ellipsis will not display yet as a TextView is set to automatically expand on default when new text is entered. You will need to limit the TextView in some way. Do do this, you can use either add to your TextView a scrollHorizontally, minLines, or maxLines to have the ellipsis display."))
        listDetails.add(GitLIstClass("MyGit ninteen", "At this point, the ellipsis will not display yet as a TextView is set to automatically expand on default when new text is entered. You will need to limit the TextView in some way. Do do this, you can use either add to your TextView a scrollHorizontally, minLines, or maxLines to have the ellipsis display."))
        listDetails.add(GitLIstClass("MyGit twenty", "At this point, the ellipsis will not display yet as a TextView is set to automatically expand on default when new text is entered. You will need to limit the TextView in some way. Do do this, you can use either add to your TextView a scrollHorizontally, minLines, or maxLines to have the ellipsis display."))

        binding.mainRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.mainRecycler.adapter = MainRcvAdapter(this, listDetails)






        binding.addNewRepo.setOnClickListener {
            val intent = Intent(this, AddNewRepo::class.java)
            startActivity(intent)
        }

        binding.addNow.setOnClickListener{
            val intent = Intent(this, AddNewRepo::class.java)
            startActivity(intent)
        }
















    }


}