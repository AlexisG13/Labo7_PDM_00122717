package com.alexg13.labo7.database.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.alexg13.labo7.database.RoomDB
import com.alexg13.labo7.database.entities.GitHubRepo
import com.alexg13.labo7.database.repositories.GitHubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoViewModel(app:Application):AndroidViewModel(app){

    private val repository:GitHubRepository

    init{
        val repoDao=RoomDB.getInstance(app).repoDAO()
        repository= GitHubRepository(repoDao)
    }

    fun getAll():LiveData<List<GitHubRepo>> = repository.getAll()

    fun insert(repo:GitHubRepo)=viewModelScope.launch(Dispatchers.IO){
        repository.insert(repo)
    }
}