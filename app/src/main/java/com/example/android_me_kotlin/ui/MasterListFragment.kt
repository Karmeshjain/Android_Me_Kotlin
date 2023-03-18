package com.example.android_me_kotlin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.example.android_me_kotlin.R
import com.example.android_me_kotlin.data.AndroidImageAssets

class MasterListFragment():Fragment()
{
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_master_list,container,false)
        val gridView=view.findViewById<GridView>(R.id.images_grid_view)
        val masterListAdapter=MasterListAdapter(context,AndroidImageAssets.all)
        gridView.adapter=masterListAdapter
        return view
    }
}