package com.mihudevcom.androidplayground.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.mihudevcom.androidplayground.MainActivity
import com.mihudevcom.androidplayground.R

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_dashboard, container, false)

        val btnAddNotification = view.findViewById<Button>(R.id.btn_add_notification)
        btnAddNotification.setOnClickListener {
            (activity as? MainActivity)?.updateBadge(3)
        }

        return view
    }
}