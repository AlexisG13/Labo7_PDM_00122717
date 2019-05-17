package com.alexg13.labo7.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alexg13.labo7.database.entities.GitHubRepo

@Dao
interface GithubRepoDao{

    @Query("SELECT*FROM repos")
    fun getAll(): LiveData<List<GitHubRepo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //suspend solo se puede utilizar en una corrutina
    suspend fun insert(repo: GitHubRepo)

    @Query("DELETE FROM repos")
    fun nukeTable()
}