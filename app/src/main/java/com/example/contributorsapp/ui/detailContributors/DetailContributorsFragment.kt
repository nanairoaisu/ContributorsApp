package com.example.contributorsapp.ui.detailContributors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.contributorsapp.R
import com.example.contributorsapp.databinding.FragmentDetailContributorsBinding

class DetailContributorsFragment : Fragment() {
    private lateinit var binding: FragmentDetailContributorsBinding
    private val listContributorsViewModel = DetailContributorsViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailContributorsBinding.inflate(inflater, container, false)

        return binding.root
    }
}