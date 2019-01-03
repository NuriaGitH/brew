package com.example.nuriaperalta.kotlinstart3.UI.HomeActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.nuriaperalta.kotlinstart3.R
import com.example.nuriaperalta.kotlinstart3.UI.BeerDetailFragment.BeerListFragment

class HomeActivity : AppCompatActivity() {

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
    }

    //Método que que se utiliza para poder instanciar después los fragments con mucho menos código
    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
        beginTransaction().func().commit()
    }
}
