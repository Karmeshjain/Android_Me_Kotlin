package com.example.android_me_kotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_me_kotlin.BodyPartFragment
import com.example.android_me_kotlin.R
import com.example.android_me_kotlin.data.AndroidImageAssets

class AndroidMeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_me)
        if(savedInstanceState==null) {
            var headFragment = BodyPartFragment()
            headFragment.mImageIds = AndroidImageAssets.heads as List<Int>
            headFragment.mListIndex = 2
            var fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction().add(R.id.head_container, headFragment).commit()

            var bodyFragment = BodyPartFragment()
            bodyFragment.mImageIds = AndroidImageAssets.bodies as List<Int>
            bodyFragment.mListIndex = 2
            fragmentManager.beginTransaction().add(R.id.body_container, bodyFragment).commit()

            var legFragment = BodyPartFragment()
            legFragment.mImageIds = AndroidImageAssets.legs as List<Int>
            legFragment.mListIndex = 2
            fragmentManager.beginTransaction().add(R.id.leg_container, legFragment).commit()
        }
    }
}