package com.example.contributorsapp.ui.listContributors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.contributorsapp.R
import com.example.contributorsapp.databinding.ListContributorBinding
import com.example.contributorsapp.model.ContributorsData

class RecyclerAdapter(private var data: List<ContributorsData>): RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    class RecyclerViewHolder(val binding: ListContributorBinding): RecyclerView.ViewHolder(binding.root)

    //クリックイベントの追加
    private lateinit var listener: OnItemClickListener

    interface OnItemClickListener{
        fun onItemClickListener(view: View, position: Int, clickedContributor: ContributorsData)
    }

    fun setOnClickListener(listener: OnItemClickListener){
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListContributorBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_contributor, parent,false)

        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val contributor = data[position]
        holder.binding.viewModel = ContributorsData(contributor.id, contributor.login, contributor.contributions, contributor.avatar_url)

        holder.binding.layoutList.setOnClickListener {
            listener.onItemClickListener(it, position, contributor)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setContributors(contributor: List<ContributorsData>){
        this.data = contributor
        notifyDataSetChanged()
    }



}