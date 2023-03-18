package com.example.android_me_kotlin.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

class MasterListAdapter(context: Context?, imageIds: List<Int?>) : BaseAdapter() {
    // Keeps track of the context and list of images to display
    private var mContext: Context? = context
    private var mImageIds: List<Int?> = imageIds

    /**
     * Returns the number of items the adapter will display
     */
    override fun getCount(): Int {
        return mImageIds!!.size
    }

    override fun getItem(i: Int): Any? {
        return null
    }

    override fun getItemId(i: Int): Long {
        return 0
    }

    /**
     * Creates a new ImageView for each item referenced by the adapter
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val imageView: ImageView
        if (convertView == null) {
            // If the view is not recycled, this creates a new ImageView to hold an image
            imageView = ImageView(mContext)
            // Define the layout parameters
            imageView.adjustViewBounds = true
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(8, 8, 8, 8)
        } else {
            imageView = convertView as ImageView
        }

        // Set the image resource and return the newly created ImageView
        imageView.setImageResource(mImageIds!![position]!!)
        return imageView
    }

}