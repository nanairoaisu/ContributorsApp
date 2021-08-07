package com.example.contributorsapp.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IContributorApi {
    @GET("repositories/90792131/contributors")
    fun fetchContributors(): Call<List<ContributorData>>

    @GET("users/{login}")
    fun fetchDetail(@Path("login") login: String): Call<DetailData>
}

