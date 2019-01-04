package com.example.nuriaperalta.kotlinstart3.UI.HomeActivity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.nuriaperalta.kotlinstart3.R
import com.example.nuriaperalta.kotlinstart3.UI.BeerDetailFragment.BeerListFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeActivity : AppCompatActivity() {

    lateinit var fabMain: FloatingActionButton
    lateinit var fab1: FloatingActionButton
    lateinit var fab2: FloatingActionButton
    lateinit var fab3: FloatingActionButton
    lateinit var fabOpen: Animation
    lateinit var fabClose: Animation
    lateinit var fabRotate: Animation
    var isOpen : Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Esconder toolbar
        val actionBar = supportActionBar
        actionBar!!.hide()

        setContentView(R.layout.activity_main)

        //Mostrar fragment en el id se pone el frame layout para cargar el fragment dentro
        supportFragmentManager.inTransaction {
            add(R.id.frame, BeerListFragment())
        }

        fabMain = findViewById(R.id.fab_main)
        fab1 = findViewById(R.id.fab_1)
        fab2 = findViewById(R.id.fab_2)
        fab3 = findViewById(R.id.fab_3)
        fabOpen = AnimationUtils.loadAnimation(applicationContext, R.anim.open_fab_1)
        fabClose = AnimationUtils.loadAnimation(applicationContext, R.anim.close_fab_1)
        fabRotate = AnimationUtils.loadAnimation(applicationContext, R.anim.rotate_main_floating_button)

        setFavMenuListeners()

    }

    //Método que que se utiliza para poder instanciar después los fragments con mucho menos código
    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
        beginTransaction().func().commit()
    }

    @SuppressLint("RestrictedApi")
    fun setFavMenuListeners(){
        fabMain.setOnClickListener {
            if(!isOpen){
                fab1.startAnimation(fabOpen)
                fab2.startAnimation(fabOpen)
                fab3.startAnimation(fabOpen)
                fabMain.startAnimation(fabRotate)
                fab1.visibility = View.VISIBLE
                fab1.isClickable = true
                fab2.visibility = View.VISIBLE
                fab2.isClickable = true
                fab3.visibility = View.VISIBLE
                fab3.isClickable = true
                isOpen = true
            } else {
                fab1.startAnimation(fabClose)
                fab2.startAnimation(fabClose)
                fab3.startAnimation(fabClose)
                fabMain.startAnimation(fabRotate)
                fab1.visibility = View.GONE
                fab2.visibility = View.GONE
                fab3.visibility = View.GONE
                isOpen = false
            }
        }
        fab1.setOnClickListener {
            
        }
    }
}
