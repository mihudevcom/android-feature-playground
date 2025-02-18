package com.mihudevcom.androidplayground.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.mihudevcom.androidplayground.R
import com.mihudevcom.androidplayground.viewmodel.UserViewModel

class HomeFragment : Fragment() {

    val userViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        val btnSetUser = view.findViewById<Button>(R.id.btn_set_user)
        btnSetUser.setOnClickListener {
            userViewModel.setUserData("John Doe", "john.doe@example.com")
        }

        return view
    }
}