package com.example.contributorsapp.ui.detailContributors

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contributorsapp.model.DetailData
import com.example.contributorsapp.model.Repository
import kotlinx.coroutines.launch

class DetailContributorsViewModel : ViewModel() {
    var detail: MutableLiveData<DetailData> =
        MutableLiveData(DetailData(0, "null", "null", "null", "null", 0, 0, 0, ""))
    private val repository = Repository()
    private var login = ""

    fun setLogin(selectedUserLogin: String) {
        login = selectedUserLogin
    }

    fun fetchDetail() {
        viewModelScope.launch {
            detail.postValue(repository.fetchUserDetail(login))
        }
    }

}