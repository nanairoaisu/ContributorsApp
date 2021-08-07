package com.example.contributorsapp.model

import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

//class ContributorsRepository(private val contributorsDao: ContributorsDao) {
class Repository() {
    val gson = GsonBuilder()
        .serializeNulls()
        .create()

    val URL = "https://api.github.com/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    private val service = retrofit.create(Interface.CreateService::class.java)

    suspend fun fetchContributorsList(): List<ContributorsData> {
        var contributorList: List<ContributorsData> = listOf()

        withContext(IO) {
            try {
                val response = service.fetchContributors().execute().body()
                if (response != null) {
                    contributorList = response
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return contributorList
    }

    suspend fun fetchUserDetail(login: String): DetailData {
        var detail = DetailData(0, "null", "null", "null", "null", 0, 0, 0, "")

        withContext(IO) {
            try {
                val response = service.fetchDetail(login).execute().body()
                if (response != null) {
                    detail = response
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        return detail
    }

//    suspend fun insertContributorsList(
//        contributorsItem: Array<ContributorsResponse.ContributorsEntity>
//    ){
//        withContext(IO){
//            contributorsDao.insert(*contributorsItem)
//        }
//    }
}