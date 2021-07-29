package com.example.contributorsapp.model

import retrofit2.Call
import retrofit2.http.GET

class Interface {
    interface CreateContributorsService{
        @GET("contributors")
        fun fetchContributors(): Call<List<ContributorsData>>
    }
}