package com.example.jsonparsingapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.jsonparsingapplication.R
import com.example.jsonparsingapplication.data.model.FactsDTO
import com.example.jsonparsingapplication.ui.adapter.FactsListAdapter
import com.example.jsonparsingapplication.ui.viewModel.HomeViewModel
import com.example.jsonparsingapplication.utils.isNetworkAvailable
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeSwipeRefreshLayout()
        getFactsList()
        homeViewModel.factsList.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                setAdapter(it)
            }
        })
        homeViewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            error_txt.text = it
        })
    }

    fun getFactsList() {
        if (isNetworkAvailable()) {
            homeViewModel.fetchFactsList()
        } else {
            error_txt.setText(R.string.no_internet_found_txt)
        }

    }

    private fun setAdapter(result: FactsDTO) {
        home_recycler_view.adapter = FactsListAdapter(result.rowsDto)
    }

    private fun initializeSwipeRefreshLayout() {
        swiperefresh_items.setOnRefreshListener {
            swiperefresh_items.isRefreshing = false
            getFactsList()
        }
    }
}