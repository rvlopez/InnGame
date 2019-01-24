package com.example.rviciana.inngame.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rviciana.inngame.R
import com.example.rviciana.inngame.domain.bo.Resources
import com.example.rviciana.inngame.domain.bo.Trailer
import com.example.rviciana.inngame.extensions.show
import kotlinx.android.synthetic.main.recycler_view_layout.*
import kotlinx.android.synthetic.main.resources_layout.*
import kotlinx.android.synthetic.main.timer_layout.*

class MainActivity : AppCompatActivity(), IndustryContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        with(recyclerView) {
            adapter = TrailerListAdapter()
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }
    }

    override fun showResources(resources: Resources) {
        resourcesLayout.show()
    }

    override fun updateClock(timer: String) {
        clock.text = timer
    }

    override fun updateFactoryLevel(level: String) {
        industryLvl.text = level
    }

    override fun addTrailer(trailer: Trailer) {
        val trailerListAdapter = recyclerView.adapter as TrailerListAdapter
        trailerListAdapter.addTrailer(trailer)
    }

    override fun showError(throwable: Throwable) {

    }

}
