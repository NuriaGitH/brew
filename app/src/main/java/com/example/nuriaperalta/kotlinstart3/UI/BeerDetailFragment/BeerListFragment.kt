package com.example.nuriaperalta.kotlinstart3.UI.BeerDetailFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nuriaperalta.kotlinstart3.Client.Model.Beer
import com.example.nuriaperalta.kotlinstart3.R
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.beer_list_layout.*
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class BeerListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.beer_list_layout, container, false)
        beerListCoroutine()

        //Manera de hacer findViewById en kotlin fragment
        val recyclerView = view?.findViewById<RecyclerView>(R.id.beer_list_recycler_view)
        recyclerView?.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        return view
    }

    fun beerListCoroutine() {
        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"
        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call, response: okhttp3.Response) {
                val body = response?.body()?.string()
                val gson = GsonBuilder().create()
                val beerList = gson.fromJson(body, Beer::class.java)
                Log.d("---Calls", "beer list request " + body)

                activity?.runOnUiThread {
                    beer_list_recycler_view.adapter = BeerListAdapter(beerList)
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                Log.d("---Exception", "BeerListFragment beerListCoroutine exception -->" + e.toString())
            }
        })

    }

}



