package com.example.food.api

import com.example.food.model.Category
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL ="https://howtodoandroid.com"

interface CategolyApi {





        @GET("Category.json")
        fun getAllCategory() : Call<List<Category>>

        companion object {

            var categolyApi: CategolyApi? = null

            fun getInstance() : CategolyApi {

                if (categolyApi == null) {
                    val retrofit = Retrofit.Builder()
                        .baseUrl("https://howtodoandroid.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                    categolyApi = retrofit.create(CategolyApi::class.java)
                }
                return categolyApi!!
            }
        }
    }
