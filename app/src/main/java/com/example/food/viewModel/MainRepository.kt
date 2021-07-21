package com.example.food.viewModel

import com.example.food.api.CategolyApi

class MainRepository constructor(private val categolyApi: CategolyApi) {
    fun getAllCategory() = categolyApi.getAllCategory()
}