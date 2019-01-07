package com.example.nuriaperalta.kotlinstart3.UI.RecipeScreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nuriaperalta.kotlinstart3.Client.Model.Beer
import com.example.nuriaperalta.kotlinstart3.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.beer_list_row.view.*

class RecipeListAdapter(val beerList: Beer) : RecyclerView.Adapter<CustomViewHolder>()  {

    override fun getItemCount(): Int {
        return beerList.videos.count()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(viewGroup?.context)
                .inflate(R.layout.recipe_list_row, viewGroup, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val beerImageView = holder?.view?.beer_image_row
        val imageUrl = beerList.videos.get(position).imageUrl
        Picasso.get().load(imageUrl).into(beerImageView)
    }

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view)