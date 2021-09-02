package com.example.contributorsapp.ui.listContributors

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contributorsapp.model.ContributorData
import com.example.contributorsapp.model.Repository
import kotlinx.coroutines.launch

class ListContributorsViewModel() : ViewModel() {
//    private val contributorsDao = AppDatabase.getDatabase(context).contributorsDao()
//    private val contributorsRepository = ContributorsRepository(contributorsDao)

    private val _contributorsList: MutableLiveData<List<ContributorData>> = MutableLiveData(listOf())
    val contributorsList: LiveData<List<ContributorData>> = _contributorsList
    private val repository = Repository()

    fun fetchContributorsList() {
        viewModelScope.launch {
            _contributorsList.postValue(repository.fetchContributorsList())
//            contributorsRepository.insertContributorsList(contributorsList.toTypedArray())
        }
    }

}