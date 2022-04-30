package com.example.latihanmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihanmvvm.R
import com.example.latihanmvvm.adapter.AdapterCountries
import com.example.latihanmvvm.viewmodel.ViewModelCountries
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var countriesAdapter : AdapterCountries

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countriesAdapter = AdapterCountries()

        initRecyclerView()
        initViewModel()

    }

    fun initRecyclerView(){
        rv_list_countries.layoutManager = LinearLayoutManager(this)
        rv_list_countries.adapter = countriesAdapter
    }

    fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(ViewModelCountries::class.java)
        viewModel.getLiveDataCountries().observe(this, Observer {
            if (it != null){
                countriesAdapter.setCountriesList(it)
                countriesAdapter.notifyDataSetChanged()
            }
        })
        viewModel.getDataCountries()
    }

}