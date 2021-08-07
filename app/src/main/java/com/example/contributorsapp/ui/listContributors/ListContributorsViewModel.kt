package com.example.contributorsapp.ui.listContributors

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contributorsapp.model.ContributorsData
import com.example.contributorsapp.model.Repository
import kotlinx.coroutines.launch

class ListContributorsViewModel() : ViewModel() {
//    private val contributorsDao = AppDatabase.getDatabase(context).contributorsDao()
//    private val contributorsRepository = ContributorsRepository(contributorsDao)

    var contributorsList: MutableLiveData<List<ContributorsData>> = MutableLiveData(listOf())
    private val repository = Repository()

    fun fetchContributorsList() {
        viewModelScope.launch {
            contributorsList.postValue(repository.fetchContributorsList())
//            contributorsRepository.insertContributorsList(contributorsList.toTypedArray())
        }
    }

}