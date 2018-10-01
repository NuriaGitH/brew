package com.example.nuriaperalta.kotlinstart3.UI.BeerDetailFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nuriaperalta.kotlinstart3.R
import com.example.nuriaperalta.kotlinstart3.R.id.visible
import kotlinx.android.synthetic.main.beer_list_layout.*

class BeerListFragment : Fragment() {
    private lateinit var linearLayoutManager: LinearLayoutManager

    fun newInstance(): BeerListFragment {
        return BeerListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

            //Inicilizar recyclerView
                    linearLayoutManager = LinearLayoutManager(context)
            beer_list_recycler_view.layoutManager = linearLayoutManager


        // Inflate the layout for this fragment
        return inflater?.inflate(R.layout.beer_list_layout,
                container, false)
    }

}