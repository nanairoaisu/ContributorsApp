package com.example.contributorsapp.model

import androidx.room.PrimaryKey

data class ContributorsData(
val id: Int,
val login: String,
val contributions: Int,
val url: String
)

