package com.mihudevcom.androidplayground.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mihudevcom.androidplayground.R
import com.mihudevcom.androidplayground.viewmodel.BadgeViewModel

class DashboardFragment : Fragment() {

    private val badgeViewModel: BadgeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        val btnAddNotification = view.findViewById<Button>(R.id.btn_add_notification)
        btnAddNotification.setOnClickListener {
            badgeViewModel.updateBadge(3)
        }

        return view
    }
}