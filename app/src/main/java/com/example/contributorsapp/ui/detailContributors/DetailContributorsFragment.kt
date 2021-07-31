package com.example.contributorsapp.ui.detailContributors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.contributorsapp.databinding.FragmentDetailContributorsBinding

class DetailContributorsFragment : Fragment() {
    private lateinit var binding: FragmentDetailContributorsBinding
    private val detailContributorsViewModel = DetailContributorsViewModel()
    private val args: DetailContributorsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailContributorsBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this
        binding.viewModel = detailContributorsViewModel

        detailContributorsViewModel.setLogin(args.login)
        detailContributorsViewModel.fetchDetail()

        return binding.root
    }
}