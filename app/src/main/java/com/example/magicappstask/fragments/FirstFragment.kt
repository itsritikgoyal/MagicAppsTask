package com.example.magicappstask.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.magicappstask.R


class FirstFragment : Fragment() {

    private var message: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_first, container, false)
        message = arguments?.getString("NAME")
        val textView: TextView = view.findViewById(R.id.text)
        textView.text = message
        val taskBtn: Button = view.findViewById(R.id.taskBtn)
        taskBtn.setOnClickListener {
            val myTaskFragment = MyTaskFragment()
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_container,myTaskFragment).commit()
        }
        return view
    }
}