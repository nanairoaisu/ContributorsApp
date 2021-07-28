package com.example.contributorsapp.ui.listContributors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.contributorsapp.R


class ListContributorsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list_contributors, container, false)

        view.button.setOnClickListener(){
            findNavController().navigate(R.id.action_list_to_detail)
        }
        return view
    }

}