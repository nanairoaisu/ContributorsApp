package com.example.contributorsapp.ui.listContributors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contributorsapp.databinding.FragmentListContributorsBinding


class ListContributorsFragment : Fragment() {
    private lateinit var binding: FragmentListContributorsBinding
    //private val listContributorsViewModel = this.context?.let { ListContributorsViewModel(it) }
    private val listContributorsViewModel = ListContributorsViewModel()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListContributorsBinding.inflate(inflater, container, false)

        listContributorsViewModel.fetchContributorsList()

        val layout = LinearLayoutManager(context)
        binding.lvContributor.layoutManager = layout
        binding.lvContributor.adapter = RecyclerAdapter(listContributorsViewModel.setContributorsList()?: listOf())
        binding.viewModel = listContributorsViewModel

        listContributorsViewModel.contributorsList.observe(viewLifecycleOwner, Observer {
            val adapter = binding.lvContributor.adapter as RecyclerAdapter
            adapter.setContributors(it)

        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        findNavController().navigate(R.id.action_list_to_detail)

    }

}

