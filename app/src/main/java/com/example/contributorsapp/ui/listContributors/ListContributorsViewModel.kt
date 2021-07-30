package com.example.contributorsapp.ui.listContributors

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contributorsapp.model.ContributorsData
import com.example.contributorsapp.model.ContributorsRepository
import com.example.contributorsapp.model.room.AppDatabase
import kotlinx.coroutines.launch

class ListContributorsViewModel(): ViewModel() {
//    private val contributorsDao = AppDatabase.getDatabase(context).contributorsDao()
//    private val contributorsRepository = ContributorsRepository(contributorsDao)

    var contributorsList: MutableLiveData<List<ContributorsData>> = MutableLiveData(listOf())
    private val contributorsRepository = ContributorsRepository()

    fun fetchContributorsList(){
        Log.v("banana","関数だぁ")

        viewModelScope.launch {
            Log.v("banana","ここまできた")
            contributorsList.postValue(contributorsRepository.fetchContributorsList())
//            contributorsRepository.insertContributorsList(contributorsList.toTypedArray())
        }

    }

    fun setContributorsList(): List<ContributorsData>? {
        return contributorsList.value
    }

}