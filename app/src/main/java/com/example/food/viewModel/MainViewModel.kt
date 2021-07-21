package com.example.food.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.food.model.Category
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private  val repository: MainRepository): ViewModel() {
    val categoryList = MutableLiveData<List<Category>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllCategory(){

        val response = repository.getAllCategory()
        response.enqueue(object : Callback<List<Category>>{
            override fun onResponse(
                call: Call<List<Category>>,
                response: Response<List<Category>>
            ) {
                categoryList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }
}