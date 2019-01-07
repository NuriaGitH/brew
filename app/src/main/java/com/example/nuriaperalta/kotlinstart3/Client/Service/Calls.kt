package com.example.nuriaperalta.kotlinstart3.Client.Service

import android.app.Activity
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.example.nuriaperalta.kotlinstart3.Client.Model.Beer
import com.example.nuriaperalta.kotlinstart3.UI.BeerListScreen.BeerListAdapter
import com.example.nuriaperalta.kotlinstart3.UI.RecipeScreen.RecipeListAdapter
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.recipe_list_layout.*
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class Calls {
    companion object { //Companion object is to make this methods statics
        fun beerListRequest(progressBar : ProgressBar?, activity : Activity?, recyclerView: RecyclerView?){
            val url = "https://api.letsbuildthatapp.com/youtube/home_feed"
            val request = Request.Builder().url(url).build()
            val client = OkHttpClient()
            progressBar?.visibility = View.VISIBLE

            client.newCall(request).enqueue(object : Callback {

                override fun onResponse(call: Call, response: okhttp3.Response) {
                    val body = response?.body()?.string()
                    val gson = GsonBuilder().create()
                    val beerList = gson.fromJson(body, Beer::class.java)
                    Log.d("---Calls", "beer list request " + body)

                    activity?.runOnUiThread {

                        recyclerView?.adapter = BeerListAdapter(beerList)
                        progressBar?.visibility = View.GONE
                    }
                }

                override fun onFailure(call: Call, e: IOException) {
                    Log.d("---Exception", "BeerListFragment beerListCoroutine exception -->" + e.toString())
                    activity?.runOnUiThread {
                        progressBar?.visibility = View.GONE
                    }
                }
            })

        }
        fun recipeListCoroutine(progressBar : ProgressBar?, activity : Activity?, recyclerView: RecyclerView?) {
            val url = "https://api.letsbuildthatapp.com/youtube/home_feed"
            val request = Request.Builder().url(url).build()
            val client = OkHttpClient()

            progressBar?.visibility = View.VISIBLE

            client.newCall(request).enqueue(object : Callback {

                override fun onResponse(call: Call, response: okhttp3.Response) {
                    val body = response?.body()?.string()
                    val gson = GsonBuilder().create()
                    val recipeList = gson.fromJson(body, Beer::class.java)
                    Log.d("---Calls", "beer list request " + body)

                    activity?.runOnUiThread {
                        recyclerView?.adapter = RecipeListAdapter(recipeList)
                        recyclerView?.adapter = RecipeListAdapter(recipeList)
                        progressBar?.visibility = View.GONE
                    }
                }

                override fun onFailure(call: Call, e: IOException) {
                    Log.d("---Exception", "BeerListFragment beerListCoroutine exception -->" + e.toString())
                    activity?.runOnUiThread {
                        progressBar?.visibility = View.GONE
                    }
                }
            })

        }
    }
}