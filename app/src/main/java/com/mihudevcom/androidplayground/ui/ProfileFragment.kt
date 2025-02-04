package com.mihudevcom.androidplayground.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mihudevcom.androidplayground.R
import com.mihudevcom.androidplayground.viewmodel.BadgeViewModel

class ProfileFragment : Fragment() {

    private val badgeViewModel: BadgeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        badgeViewModel.updateBadge(0)

        return view
    }
}