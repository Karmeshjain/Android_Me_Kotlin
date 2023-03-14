package com.example.android_me_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.android_me_kotlin.data.AndroidImageAssets

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [BodyPartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BodyPartFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_body_part,container,false)
        var imageView=view.findViewById<View>(R.id.body_part_image_view) as ImageView
        imageView.setImageResource(AndroidImageAssets.heads[0]!!)
        return view
    }
}