package com.example.contributorsapp.ui.listContributors

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.contributorsapp.R
import com.example.contributorsapp.databinding.FragmentListContributorsBinding


class ListContributorsFragment : Fragment() {
    private lateinit var binding: FragmentListContributorsBinding
    //private val listContributorsViewModel = this.context?.let { ListContributorsViewModel(it) }
    private val listContributorsViewModel = ListContributorsViewModel()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListContributorsBinding.inflate(inflater, container, false)

        binding.button.setOnClickListener(){
            Log.v("banana","クリックした")
            listContributorsViewModel?.fetchContributorsList()
            findNavController().navigate(R.id.action_list_to_detail)
        }
        return binding.root
    }

}