package com.example.contributorsapp.model

data class DetailData(
    val id: Int,
    val name: String,
    val login: String,
    val avatar_url: String,
    val html_url: String,
    val followers: Int,
    val following: Int,
    val public_repos: Int,
    val repos_url: String
)
