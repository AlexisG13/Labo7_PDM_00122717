package com.alexg13.labo7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexg13.labo7.database.viewmodels.GithubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter:ReposAdapter
    lateinit var viewModel:GithubRepoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
    }

    fun bind(){
        adapter= ReposAdapter(ArrayList())
        viewModel= ViewModelProviders.of(this).get(GithubRepoViewModel::class.java)
        recycler_view.apply {
            adapter=this@MainActivity.adapter
            layoutManager=LinearLayoutManager(this@MainActivity)
        }
    }
}
