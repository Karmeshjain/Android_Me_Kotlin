package com.example.android_me_kotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android_me_kotlin.data.AndroidImageAssets
import com.example.android_me_kotlin.ui.AndroidMeActivity
import com.example.android_me_kotlin.ui.MasterListFragment


class MainActivity : AppCompatActivity(),MasterListFragment.OnImageClickListener {

    var headIndex:Int=0
    var bodyIndex:Int=0
    var legIndex:Int=0
    var mTwoPane:Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (findViewById<View>(R.id.android_me_linear_layout) != null)
        {
            mTwoPane=true
            var gridView=findViewById<GridView>(R.id.images_grid_view);
            gridView.numColumns=2
            val button:Button=findViewById(R.id.next_button)
            button.visibility=View.GONE
            if(savedInstanceState==null)
            {
                var fragmentManager = supportFragmentManager

                var headFragment = BodyPartFragment()
                headFragment.mImageIds = AndroidImageAssets.heads as List<Int>

                fragmentManager.beginTransaction().add(R.id.head_container, headFragment).commit()

                var bodyFragment = BodyPartFragment()
                bodyFragment.mImageIds = AndroidImageAssets.bodies as List<Int>

                fragmentManager.beginTransaction().add(R.id.body_container, bodyFragment).commit()

                var legFragment = BodyPartFragment()
                legFragment.mImageIds = AndroidImageAssets.legs as List<Int>

                fragmentManager.beginTransaction().add(R.id.leg_container, legFragment).commit()
            }
        }
        else
            mTwoPane=false;

    }

    override fun onImageSelected(position: Int) {
        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show()
        var bodyPartNumber=position/12;
        var listIndex=position-12*bodyPartNumber;

        if(mTwoPane)
        {
            var newFragment=BodyPartFragment()
            when(bodyPartNumber)
            {
                0 -> {
                    // A head image has been clicked
                    // Give the correct image resources to the new fragment
                    newFragment.mImageIds = AndroidImageAssets.heads as List<Int>
                    newFragment.mListIndex = listIndex
                    // Replace the old head fragment with a new one
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.head_container, newFragment)
                        .commit()
                }
                1 -> {
                    newFragment.mImageIds = AndroidImageAssets.bodies as List<Int>
                    newFragment.mListIndex=listIndex
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.body_container, newFragment)
                        .commit()
                }
                2 -> {
                    newFragment.mImageIds=AndroidImageAssets.legs as List<Int>
                    newFragment.mListIndex=listIndex
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.leg_container, newFragment)
                        .commit()
                }
                else -> {
                    // Handle the default case
                }

            }

        }
         else {
            when (bodyPartNumber) {
                0 -> headIndex = listIndex
                1 -> bodyIndex = listIndex
                2 -> legIndex = listIndex
                else -> {}
            }
        }
        val b=Bundle()
        b.putInt("headIndex", headIndex)
        b.putInt("bodyIndex", bodyIndex)
        b.putInt("legIndex", legIndex)

        val intent = Intent(this, AndroidMeActivity::class.java)
        intent.putExtras(b)

        val nextButton=findViewById<Button>(R.id.next_button)
        nextButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                startActivity(intent)
            }
        })



    }
}