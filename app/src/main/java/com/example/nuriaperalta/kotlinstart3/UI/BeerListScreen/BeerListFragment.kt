package com.example.nuriaperalta.kotlinstart3.UI.BeerListScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nuriaperalta.kotlinstart3.Client.Service.Calls
import com.example.nuriaperalta.kotlinstart3.R

class BeerListFragment : Fragment() {
    var progressBar : ProgressBar? = null
    var recyclerView : RecyclerView? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.beer_list_layout, container, false)

        //Manera de hacer findViewById en kotlin fragment
        recyclerView = view?.findViewById(R.id.beer_list_recycler_view)
        recyclerView?.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        progressBar = view?.findViewById(R.id.beer_list_bar)

        Calls.beerListRequest(progressBar, activity, recyclerView)

        return view
    }

}



