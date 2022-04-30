package com.example.latihanmvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.latihanmvvm.R
import com.example.latihanmvvm.model.GetAllCountriesResponseItem
import kotlinx.android.synthetic.main.item_countries_adapter.view.*

class AdapterCountries(): RecyclerView.Adapter<AdapterCountries.ViewHolder>() {

    private var countriesData: List<GetAllCountriesResponseItem>? = null

    fun setCountriesList(countriesList: List<GetAllCountriesResponseItem>){
        this.countriesData = countriesList
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_countries_adapter, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_name_countries.text = countriesData!![position].name
        holder.itemView.tv_capital_countries.text = countriesData!![position].capital
        holder.itemView.tv_region_countries.text = countriesData!![position].region
        holder.itemView.tv_population_countries.text = countriesData!![position].population.toString()

        Glide.with(holder.itemView.context).load(countriesData!![position].flags.png).into(holder.itemView.iv_image_countries)
    }

    override fun getItemCount(): Int {
        if (countriesData == null){
            return 0
        }else{
            return countriesData!!.size
        }
    }
}