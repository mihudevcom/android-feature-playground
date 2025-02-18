package com.mihudevcom.androidplayground.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.mihudevcom.androidplayground.R
import com.mihudevcom.androidplayground.viewmodel.BadgeViewModel
import com.mihudevcom.androidplayground.viewmodel.UserViewModel

class ProfileFragment : Fragment() {

    private val badgeViewModel: BadgeViewModel by activityViewModels()
    private val userViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val userNameText = view.findViewById<TextView>(R.id.username)
        val emailText = view.findViewById<TextView>(R.id.email)

        badgeViewModel.updateBadge(0)

        userViewModel.userName.observe(viewLifecycleOwner) { username ->
            userNameText.setText(username)
        }

        userViewModel.email.observe(viewLifecycleOwner) { email ->
            emailText.setText(email)
        }

        return view
    }
}