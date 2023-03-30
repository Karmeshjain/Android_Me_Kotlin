package com.example.android_me_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android_me_kotlin.ui.AndroidMeActivity
import com.example.android_me_kotlin.ui.MasterListFragment


class MainActivity : AppCompatActivity(),MasterListFragment.OnImageClickListener {

    var headIndex:Int=0
    var bodyIndex:Int=0
    var legIndex:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onImageSelected(position: Int) {
        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show()
        var bodyPartNumber=position/12;
        var listIndex=position-12*bodyPartNumber;
        when (bodyPartNumber) {
            0 -> headIndex = listIndex
            1 -> bodyIndex = listIndex
            2 -> legIndex = listIndex
            else -> {}
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