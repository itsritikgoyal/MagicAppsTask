package com.example.magicappstask.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.magicappstask.R
import com.example.magicappstask.RecyclerAdapter


class MyTaskFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_my_task, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        val titles: Array<String> = resources.getStringArray(R.array.Titles)
        val images: Array<String> = resources.getStringArray(R.array.Images)
        val adapter = RecyclerAdapter(images,titles)
        val gridLayout =  GridLayoutManager(requireContext(),2)
        recyclerView.layoutManager = gridLayout
        recyclerView.adapter = adapter

        return view
    }


}