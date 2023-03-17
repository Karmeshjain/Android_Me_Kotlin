package com.example.android_me_kotlin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [BodyPartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
 class BodyPartFragment() : Fragment() {

    val TAG="BodyPartFragment"
    val image_id_list="image_ids"
    val list_index="list_index"
    var mImageIds = listOf<Int>()

    var mListIndex:Int = 0;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        if(savedInstanceState !=null)
        {
            mImageIds= savedInstanceState.getIntegerArrayList(image_id_list)!!
            mListIndex=savedInstanceState.getInt(list_index)
        }
        val view=inflater.inflate(R.layout.fragment_body_part,container,false)
        var imageView=view.findViewById<View>(R.id.body_part_image_view) as ImageView
        if(mImageIds!=null) {
            imageView.setImageResource(mImageIds.get(mListIndex)!!)
            imageView.setOnClickListener(View.OnClickListener {
                if(mListIndex<mImageIds.size -1)
                    mListIndex++
                 imageView.setImageResource(mImageIds.get(mListIndex))
            })
        }
        else
        {
            Log.d("TAG", "List is empty")
        }
        return view
    }

    override fun onSaveInstanceState(currentState: Bundle) {
        currentState.putIntegerArrayList(image_id_list,ArrayList(mImageIds))
        currentState.putInt(list_index,mListIndex)
    }
}