package com.alexg13.labo7.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.alexg13.labo7.database.daos.GithubRepoDao
import com.alexg13.labo7.database.entities.GitHubRepo

class GitHubRepository(private val repoDao: GithubRepoDao){
    fun getAll():LiveData<List<GitHubRepo>> = repoDao.getAll()

    fun nuke()= repoDao.nukeTable()

    @WorkerThread
    suspend fun insert(repo:GitHubRepo)= repoDao.insert(repo)
}