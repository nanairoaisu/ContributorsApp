package com.example.contributorsapp.ui.listContributors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.contributorsapp.R
import com.example.contributorsapp.databinding.ListContributorBinding
import com.example.contributorsapp.model.ContributorsData

class RecyclerAdapter(val context: Context, private var data: List<ContributorsData>) : RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    class RecyclerViewHolder(val binding: ListContributorBinding) : RecyclerView.ViewHolder(binding.root)

    //クリックイベントの追加
    private lateinit var listener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClickListener(view: View, position: Int, clickedContributor: ContributorsData)
    }

    fun setOnClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListContributorBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_contributor, parent, false)

        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val contributor = data[position]
        holder.binding.viewModel = ContributorsData(
            contributor.id,
            contributor.login,
            contributor.contributions,
            contributor.avatar_url
        )

        Glide.with(context)
            .load(contributor.avatar_url)
            .circleCrop()
            .transition(DrawableTransitionOptions.withCrossFade()) // default is 300
            .into(holder.binding.ivIcon)

        holder.binding.layoutList.setOnClickListener {
            listener.onItemClickListener(it, position, contributor)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setContributors(contributor: List<ContributorsData>) {
        this.data = contributor
        notifyDataSetChanged()
    }


}