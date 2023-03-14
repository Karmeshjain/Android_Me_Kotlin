package com.example.android_me_kotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.android_me_kotlin.BodyPartFragment
import com.example.android_me_kotlin.R

class AndroidMeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_me)
        var headFragment=BodyPartFragment()
        var fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().add(R.id.head_container,headFragment).commit()

    }
}