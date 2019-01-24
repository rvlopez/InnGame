package com.example.rviciana.inngame.presentation

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rviciana.inngame.InnGameApplication
import com.example.rviciana.inngame.R
import com.example.rviciana.inngame.domain.bo.Resources
import com.example.rviciana.inngame.domain.bo.Trailer
import com.example.rviciana.inngame.extensions.show
import kotlinx.android.synthetic.main.recycler_view_layout.*
import kotlinx.android.synthetic.main.board_layout.*
import javax.inject.Inject

class IndustryActivity : AppCompatActivity(), IndustryContract.View {

    @Inject
    lateinit var presenter: IndustryContract.Presenter

    private val Activity.app: InnGameApplication get() = application as InnGameApplication
    private val component by lazy { app.component }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeInjector()
        initializePresenter()
        initViews()

        presenter.onViewReady()
    }

    private fun initViews() {
        with(recyclerView) {
            adapter = TrailerListAdapter()
            layoutManager = LinearLayoutManager(this@IndustryActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false)
            setHasFixedSize(true)
        }
    }

    private fun initializeInjector() {
        component.inject(this@IndustryActivity)
    }

    private fun initializePresenter() {
        presenter.setView(this@IndustryActivity)
    }

    override fun showResources(resources: Resources) {
        resourcesLayout.show()

        metal.text = resources.metal.toString()
        fibre.text = resources.fibre.toString()
        gasoline.text = resources.gasoline.toString()
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
