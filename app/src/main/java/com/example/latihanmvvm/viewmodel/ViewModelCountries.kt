package com.example.latihanmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.latihanmvvm.model.GetAllCountriesResponseItem
import com.example.latihanmvvm.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelCountries: ViewModel() {

    lateinit var liveDataCountries: MutableLiveData<List<GetAllCountriesResponseItem>>

    init {
        liveDataCountries = MutableLiveData()
    }

    @JvmName("getLiveDataCountries1")
    fun getLiveDataCountries(): MutableLiveData<List<GetAllCountriesResponseItem>>{
        return liveDataCountries
    }

    fun getDataCountries(){
        ApiClient.instance.getAllDataNews()
            .enqueue(object : Callback<List<GetAllCountriesResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllCountriesResponseItem>>,
                    response: Response<List<GetAllCountriesResponseItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataCountries.postValue(response.body())
                    }else{
                        liveDataCountries.postValue(null)
                    }
                }

                override fun onFailure(
                    call: Call<List<GetAllCountriesResponseItem>>,
                    t: Throwable
                ) {
                    liveDataCountries.postValue(null)
                }

            })
    }

}