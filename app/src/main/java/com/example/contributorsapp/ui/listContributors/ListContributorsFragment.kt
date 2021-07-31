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
import com.example.contributorsapp.R
import com.example.contributorsapp.databinding.FragmentListContributorsBinding
import com.example.contributorsapp.model.ContributorsData


class ListContributorsFragment : Fragment() {
    private lateinit var binding: FragmentListContributorsBinding
    //private val listContributorsViewModel = this.context?.let { ListContributorsViewModel(it) }
    private val listContributorsViewModel = ListContributorsViewModel()

    private lateinit var adapter: RecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListContributorsBinding.inflate(inflater, container, false)

        listContributorsViewModel.fetchContributorsList()

        val dividerItemDecoration = DividerItemDecoration(context, LinearLayoutManager(context).orientation)
        binding.lvContributor.addItemDecoration(dividerItemDecoration)
        val layout = LinearLayoutManager(context)
        binding.lvContributor.layoutManager = layout
        binding.viewModel = listContributorsViewModel
        adapter = RecyclerAdapter(listContributorsViewModel.contributorsList.value?: listOf())
        binding.lvContributor.adapter = adapter


        listContributorsViewModel.contributorsList.observe(viewLifecycleOwner, Observer {
            adapter = binding.lvContributor.adapter as RecyclerAdapter
            adapter.setContributors(it)

        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.setOnClickListener(
            object: RecyclerAdapter.OnItemClickListener{
                override fun onItemClickListener(
                    view: View,
                    position: Int,
                    clickedContributor: ContributorsData
                ) {
                    val login = listContributorsViewModel.contributorsList.value?.get(position)?.login?: ""
                    val action = ListContributorsFragmentDirections.actionListToDetail(login)
                    findNavController().navigate(action)
                }
            }
        )
    }
}

