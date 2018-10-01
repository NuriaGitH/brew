package com.example.nuriaperalta.kotlinstart3.UI.BeerDetailFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nuriaperalta.kotlinstart3.Client.Model.Beer
import com.example.nuriaperalta.kotlinstart3.R

class BeerListAdapter(val beerList: ArrayList<Beer>)  : RecyclerView.Adapter<BeerListAdapter.ViewHolder>()  {

    override fun onBindViewHolder(viewGroup: ViewHolder, position: Int) {
        val beer : Beer = beerList[position]
        viewGroup?.textViewName?.text = beer.name
        viewGroup?.textViewKind?.text = beer.kind
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup?.context).inflate(R.layout.beer_list_row, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return beerList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName = itemView.findViewById(R.id.beer_name_row) as TextView
        val textViewKind = itemView.findViewById(R.id.beer_kind_row) as TextView
    }
}