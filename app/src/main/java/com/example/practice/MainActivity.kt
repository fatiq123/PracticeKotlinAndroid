package com.example.practice

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    private val firstFragment = FirstFragment()
    private val secondFragment = SecondFragment()
    private val thirdFragment = ThirdFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchFragment(firstFragment)

        val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener{
            when (it.itemId){
                R.id.miHome -> {
                    switchFragment(firstFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.miMessage -> {
                    switchFragment(secondFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.miProfile -> {
                    switchFragment(thirdFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

        val navigation: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)


        // to display badges on message icon
        addBadges(navigation,R.id.miMessage,5)
    }


    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.flFragment, fragment)
            .commit()
    }

    private fun addBadges(navigation: BottomNavigationView, itemId: Int, count: Int) {
        val badge = navigation.getOrCreateBadge(itemId)
        badge.number = count
        badge.badgeTextColor = ContextCompat.getColor(this,R.color.badge_color)
        badge.backgroundColor = ContextCompat.getColor(this,android.R.color.white)
        badge.isVisible = true
    }
}