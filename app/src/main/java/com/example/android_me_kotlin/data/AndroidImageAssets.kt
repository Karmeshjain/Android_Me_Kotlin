package com.example.android_me_kotlin.data

import com.example.android_me_kotlin.R

object AndroidImageAssets {
    // Getter methods that return lists of all head images, body images, and leg images
    // Lists for all AndroidMe images
    // Broken down into heads, bodies, legs, and all images
    val heads: List<Int?> = object : ArrayList<Int?>() {
        init {
            add(R.drawable.head1)
            add(R.drawable.head2)
            add(R.drawable.head3)
            add(R.drawable.head4)
            add(R.drawable.head5)
            add(R.drawable.head6)
            add(R.drawable.head7)
            add(R.drawable.head8)
            add(R.drawable.head9)
            add(R.drawable.head10)
            add(R.drawable.head11)
            add(R.drawable.head12)
        }
    }
    val bodies: List<Int?> = object : ArrayList<Int?>() {
        init {
            add(R.drawable.body1)
            add(R.drawable.body2)
            add(R.drawable.body3)
            add(R.drawable.body4)
            add(R.drawable.body5)
            add(R.drawable.body6)
            add(R.drawable.body7)
            add(R.drawable.body8)
            add(R.drawable.body9)
            add(R.drawable.body10)
            add(R.drawable.body11)
            add(R.drawable.body12)
        }
    }
    val legs: List<Int?> = object : ArrayList<Int?>() {
        init {
            add(R.drawable.legs1)
            add(R.drawable.legs2)
            add(R.drawable.legs3)
            add(R.drawable.legs4)
            add(R.drawable.legs5)
            add(R.drawable.legs6)
            add(R.drawable.legs7)
            add(R.drawable.legs8)
            add(R.drawable.legs9)
            add(R.drawable.legs10)
            add(R.drawable.legs11)
            add(R.drawable.legs12)
        }
    }

    // Returns a list of all the images combined: heads, bodies, and legs in that order
    val all: List<Int?> = object : ArrayList<Int?>() {
        init {
            addAll(heads)
            addAll(bodies)
            addAll(legs)
        }
    }

}
