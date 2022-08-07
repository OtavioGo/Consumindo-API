package com.example.testecepapikotlin.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testecepapikotlin.model.Chuck
import com.example.testecepapikotlin.model.Post
import com.example.testecepapikotlin.model.slip
import com.example.testecepapikotlin.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<slip>> = MutableLiveData()
    val myResponse3: MutableLiveData<Response<Chuck>> = MutableLiveData()

    fun getNumberCEP(number: String){
        viewModelScope.launch {
            val response = repository.getNumberCEP(number)
            myResponse.value = response
        }
    }

    fun getAdvice(){
        viewModelScope.launch {
            val response = repository.getAdvice()
            myResponse2.value = response
        }
    }

    fun getChuckNorris(){
        viewModelScope.launch {
            val response = repository.getChuckNorris()
            myResponse3.value = response
        }
    }
}