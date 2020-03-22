package com.example.jsonparsingapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonparsingapplication.R
import com.example.jsonparsingapplication.data.model.RowsDTO
import com.example.jsonparsingapplication.databinding.HolderFactsBinding

class FactsListAdapter constructor(private var factsList : List<RowsDTO>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderPostBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.holder_facts, parent, false
        )
        return FactsViewHolder(holderPostBinding)
    }

    override fun getItemCount(): Int {
        return factsList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as FactsViewHolder).onBind(factsList[position])
    }


    inner class FactsViewHolder(private val viewDataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        fun onBind(item: RowsDTO) {
            if (viewDataBinding is HolderFactsBinding) {
                viewDataBinding.facts = item
            }
        }
    }
}