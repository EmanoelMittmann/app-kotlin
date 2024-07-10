package com.example.myapplication.UI

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.commons.RequestStatus
import com.example.myapplication.data.domain.Client
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.myapplication.data.repositories.ClientRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val clientRepository: ClientRepository
) : ViewModel() {

    init {
        getData()
    }

    fun getData(): LiveData<RequestStatus<List<Client>>>{
        val liveData = MutableLiveData<RequestStatus<List<Client>>>()

        liveData.postValue(RequestStatus.Loading)

        viewModelScope.launch(Dispatchers.IO){
            try {
                val data = clientRepository.fetchClient()
                print(data)
                liveData.postValue(RequestStatus.Sucess(data));
            }catch (e: Exception){
                liveData.postValue(RequestStatus.Error(e))
            }
        }

        return liveData;
    }
}