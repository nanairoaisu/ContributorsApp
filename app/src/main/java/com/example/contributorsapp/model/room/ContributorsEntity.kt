package com.example.contributorsapp.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey

data class ContributorsResponse(
    val contributors: List<ContributorsEntity>
){
    @Entity(tableName = "contributors_table")
    data class ContributorsEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val login: String,
        val contributions: Int,
        val url: String
    )
}

