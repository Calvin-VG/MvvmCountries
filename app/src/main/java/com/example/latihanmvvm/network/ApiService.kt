package com.example.latihanmvvm.network

import com.example.latihanmvvm.model.GetAllCountriesResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("all")
    fun getAllDataNews() : Call<List<GetAllCountriesResponseItem>>

}