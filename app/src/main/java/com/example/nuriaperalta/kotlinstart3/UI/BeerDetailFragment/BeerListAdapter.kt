package com.example.nuriaperalta.kotlinstart3.UI.BeerDetailFragment

import android.content.Intent
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nuriaperalta.kotlinstart3.R
import kotlinx.android.synthetic.main.beer_list_row.view.*

class BeerListAdapter(private val photos: ArrayList<ContactsContract.Contacts.Photo>)  : RecyclerView.Adapter<BeerListAdapter.PhotoHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerListAdapter.PhotoHolder {
        val inflatedView = parent.inflate(R.layout.beer_list_row, false)
        return PhotoHolder(inflatedView)
    }

    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: BeerListAdapter.PhotoHolder, position: Int) {
        val itemPhoto = photos[position]
        holder.bindPhoto(itemPhoto)
    }

    //Holder of the recyclerView
    class PhotoHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        private var photo: ContactsContract.Contacts.Photo? = null


        init {
            v.setOnClickListener(this)
        }


        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!")
            val context = itemView.context
            val showPhotoIntent = Intent(context, PhotoActivity::class.java)
            showPhotoIntent.putExtra(PHOTO_KEY, photo)
            context.startActivity(showPhotoIntent)
        }

        companion object {
            private val PHOTO_KEY = "PHOTO"
        }

        fun bindPhoto(photo: ContactsContract.Contacts.Photo) {
            this.photo = photo
            Picasso.with(view.context).load(photo.url).into(view.itemImage)
            view.itemDate.text = photo.humanDate
            view.itemDescription.text = photo.explanation
        }
    }
}