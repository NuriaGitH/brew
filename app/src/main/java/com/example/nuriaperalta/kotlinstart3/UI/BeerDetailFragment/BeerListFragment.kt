package com.example.nuriaperalta.kotlinstart3.UI.BeerDetailFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nuriaperalta.kotlinstart3.Client.Model.Beer
import com.example.nuriaperalta.kotlinstart3.R
import com.example.nuriaperalta.kotlinstart3.R.id.container
import com.example.nuriaperalta.kotlinstart3.R.id.visible
import kotlinx.android.synthetic.main.beer_list_layout.*

class BeerListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.beer_list_layout, container, false)

        //Manera de hacer findViewById en kotlin fragment
        val recyclerView = view?.findViewById<RecyclerView>(R.id.beer_list_recycler_view)
        recyclerView?.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

        val beers = ArrayList<Beer> ()

        beers.add(Beer("Belga", "Stout"))
        beers.add(Beer("ett", "Stout"))
        beers.add(Beer("Belga", "Stout"))
        beers.add(Beer("Belga", "Stout"))
        beers.add(Beer("Belga", "Stout"))
        beers.add(Beer("Belga", "Stout"))
        beers.add(Beer("Belga", "Stout"))
        beers.add(Beer("Belga", "Stout"))
        beers.add(Beer("Belga", "Stout"))
        beers.add(Beer("Belga", "Stout"))

        val adapter = BeerListAdapter(beers)

        recyclerView?.adapter = adapter
        // Inflate the layout for this fragment
        return view
    }
}