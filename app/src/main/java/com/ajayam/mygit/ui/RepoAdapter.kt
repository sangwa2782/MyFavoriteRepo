package com.ajayam.mygit.ui

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ajayam.mygit.R
import com.ajayam.mygit.data.RepoData

class RepoAdapter(val context: Context, private val listDetails: MutableList<RepoData>?) :
    RecyclerView.Adapter<RepoAdapter.MainViewHolder>() {


    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvName)
        val desc: TextView = itemView.findViewById(R.id.tvDesc)
        val cvRepo: CardView = itemView.findViewById(R.id.cvRepo)
        val ivShare: ImageView = itemView.findViewById(R.id.ivShare)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.added_list_layout, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listDetails!!.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.name.text = listDetails?.get(position)?.repoName
        holder.desc.text = listDetails?.get(position)?.description

        onclick(holder, position)
    }

    private fun onclick(holder: MainViewHolder, position: Int) {

        //redirecting git repo url to browser
        holder.cvRepo.setOnClickListener(View.OnClickListener {
            var url: String = listDetails?.get(position)?.url.toString()
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "http://$url"
            }
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(browserIntent)
        })

        //sharing repo name and url to social apps
        holder.ivShare.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(
                Intent.EXTRA_TEXT,
                listDetails?.get(position)?.repoName + " \n" + listDetails?.get(position)?.url
            )
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

            try {
                context.startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                ex.printStackTrace()
            }
        })
    }


}