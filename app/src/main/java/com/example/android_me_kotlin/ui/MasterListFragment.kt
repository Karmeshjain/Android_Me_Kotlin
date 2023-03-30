package com.example.android_me_kotlin.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.example.android_me_kotlin.R
import com.example.android_me_kotlin.data.AndroidImageAssets


class MasterListFragment():Fragment()
{
    var mCallBack:OnImageClickListener?=null
interface OnImageClickListener
{
 fun onImageSelected(position:Int)
}

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mCallBack = context as OnImageClickListener
        }
        catch (e:java.lang.ClassCastException)
        {
            throw java.lang.ClassCastException(context.toString()+"must Implement onImageClickListener")
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_master_list,container,false)
        val gridView=view.findViewById<GridView>(R.id.images_grid_view)
        val masterListAdapter=MasterListAdapter(context,AndroidImageAssets.all)
        gridView.adapter=masterListAdapter
        gridView.onItemClickListener =
            OnItemClickListener { adapterView, view, position, l -> // Trigger the callback method and pass in the position that was clicked
                mCallBack!!.onImageSelected(position)
            }
        return view
    }
}