package com.example.contributorsapp.ui.detailContributors

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contributorsapp.model.DetailData
import com.example.contributorsapp.model.Repository
import kotlinx.coroutines.launch

class DetailContributorsViewModel : ViewModel() {
    private val _detail: MutableLiveData<DetailData> =
        MutableLiveData()
    val detail: LiveData<DetailData> = _detail
    private val repository = Repository()
    private var login = ""

    fun setLogin(selectedUserLogin: String) {
        login = selectedUserLogin
    }

    fun fetchDetail() {
        viewModelScope.launch {
            _detail.postValue(repository.fetchUserDetail(login))
        }
    }

}