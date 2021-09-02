package com.example.contributorsapp.ui.detailContributors

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.contributorsapp.databinding.FragmentDetailContributorsBinding
import com.example.contributorsapp.model.DetailData

class DetailContributorsFragment : Fragment() {
    private lateinit var binding: FragmentDetailContributorsBinding
    private val detailContributorsViewModel = DetailContributorsViewModel()
    private val args: DetailContributorsFragmentArgs by navArgs()
    private lateinit var intent: Intent

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailContributorsBinding.inflate(inflater, container, false)

        binding.let {
            it.lifecycleOwner = viewLifecycleOwner
            it.viewModel = detailContributorsViewModel
        }

        detailContributorsViewModel.setLogin(args.login)
        detailContributorsViewModel.fetchDetail()

        val detailObserver = Observer<DetailData> { newDetail ->
            context?.let {
                Glide.with(it)
                    .load(newDetail.avatar_url)
                    .circleCrop()
                    .transition(DrawableTransitionOptions.withCrossFade()) // default is 300
                    .into(binding.ivIcon)
            }

            val uri = Uri.parse(newDetail.html_url)
            intent = Intent(Intent.ACTION_VIEW, uri)

        }

        detailContributorsViewModel.detail.observe(viewLifecycleOwner, detailObserver)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btBrowser.setOnClickListener {
            startActivity(intent)
        }

    }
}