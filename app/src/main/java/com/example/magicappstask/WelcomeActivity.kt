package com.example.magicappstask

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.magicappstask.fragments.FirstFragment

class WelcomeActivity : AppCompatActivity() {

    private lateinit var myPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val firstFragment = FirstFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,firstFragment).commit()

        myPreferences = getSharedPreferences("preferences", MODE_PRIVATE)

        val name: String? = myPreferences.getString("usernameText",null)

        val bundle  = Bundle()
        bundle.putString("NAME",name)
        firstFragment.arguments = bundle

    }
}