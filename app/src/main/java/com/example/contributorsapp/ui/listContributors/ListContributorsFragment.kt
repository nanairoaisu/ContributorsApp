package com.example.contributorsapp.ui.listContributors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contributorsapp.databinding.FragmentListContributorsBinding
import com.example.contributorsapp.model.ContributorData


class ListContributorsFragment : Fragment() {
    private lateinit var binding: FragmentListContributorsBinding

    //private val listContributorsViewModel = this.context?.let { ListContributorsViewModel(it) }
    private val listContributorsViewModel = ListContributorsViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListContributorsBinding.inflate(inflater, container, false)

        listContributorsViewModel.fetchContributorsList()
        showAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showAdapter()
    }

    private fun showAdapter() {
        val dividerItemDecoration =
            DividerItemDecoration(context, LinearLayoutManager(context).orientation)
        binding.lvContributor.addItemDecoration(dividerItemDecoration)
        val layout = LinearLayoutManager(context)
        binding.lvContributor.layoutManager = layout
        binding.viewModel = listContributorsViewModel
        var adapter = activity?.let {
            ContributorListAdapter(
                it,
                listContributorsViewModel.contributorsList.value ?: listOf()
            )
        }
        binding.lvContributor.adapter = adapter

        listContributorsViewModel.contributorsList.observe(viewLifecycleOwner, Observer {
            adapter = binding.lvContributor.adapter as ContributorListAdapter
            adapter?.setContributors(it)

        })

        adapter?.setOnClickListener(
            object : ContributorListAdapter.OnItemClickListener {
                override fun onItemClickListener(
                    view: View,
                    position: Int,
                    clickedContributor: ContributorData
                ) {
                    val login = listContributorsViewModel.contributorsList.value?.get(position)?.login ?: ""
                    val action = ListContributorsFragmentDirections.actionListToDetail(login)
                    findNavController().navigate(action)

                }
            }
        )


    }
}

