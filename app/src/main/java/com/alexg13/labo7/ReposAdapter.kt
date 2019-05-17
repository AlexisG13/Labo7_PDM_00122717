package com.alexg13.labo7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexg13.labo7.database.entities.GitHubRepo
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.repo_cardview.view.*

class ReposAdapter (var repos:List<GitHubRepo>): RecyclerView.Adapter<ReposAdapter.ViewHolder>(){
    override fun getItemCount(): Int {
        return repos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(repos[position])
    }

    fun updateList(newRepos:List<GitHubRepo>){
        this.repos=newRepos
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repo_cardview,parent,false)
        return ViewHolder(view)
    }


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        fun bind(repo:GitHubRepo)= with(itemView){
            tv_repo_name.text=repo.name
        }
    }

}


