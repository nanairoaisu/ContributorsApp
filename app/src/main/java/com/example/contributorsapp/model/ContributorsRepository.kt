package com.example.contributorsapp.model

import android.util.Log
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

//class ContributorsRepository(private val contributorsDao: ContributorsDao) {
class ContributorsRepository() {
    val gson = GsonBuilder()
        .serializeNulls()
        .create()

    val URL = "https://api.github.com/repositories/90792131/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    private val service = retrofit.create(Interface.CreateContributorsService::class.java)

    suspend fun fetchContributorsList(): List<ContributorsData>{
        var contributorList: List<ContributorsData> = listOf()

        withContext(IO){
            try{
                val response = service.fetchContributors().execute().body()
                if(response != null){
                    contributorList = response
                }
            }catch (e: IOException){
                e.printStackTrace()
            }
        }
        return contributorList
    }

//    suspend fun insertContributorsList(
//        contributorsItem: Array<ContributorsResponse.ContributorsEntity>
//    ){
//        withContext(IO){
//            contributorsDao.insert(*contributorsItem)
//        }
//    }
}