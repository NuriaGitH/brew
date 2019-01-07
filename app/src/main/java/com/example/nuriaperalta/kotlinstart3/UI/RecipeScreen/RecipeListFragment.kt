package com.example.nuriaperalta.kotlinstart3.UI.RecipeScreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nuriaperalta.kotlinstart3.Client.Model.Beer
import com.example.nuriaperalta.kotlinstart3.Client.Service.Calls
import com.example.nuriaperalta.kotlinstart3.R
import com.example.nuriaperalta.kotlinstart3.UI.BeerListScreen.BeerListAdapter
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.beer_list_layout.*
import kotlinx.android.synthetic.main.recipe_list_layout.*
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class RecipeListFragment : Fragment() {
    var progressBar : ProgressBar? = null
    var recyclerView : RecyclerView? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.recipe_list_layout, container, false)

        //Manera de hacer findViewById en kotlin fragment
        recyclerView = view?.findViewById<RecyclerView>(R.id.recipe_list_recycler_view)
        recyclerView?.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        progressBar = view?.findViewById(R.id.beer_list_bar)

        Calls.recipeListCoroutine(progressBar, activity, recyclerView)

        return view
    }
}