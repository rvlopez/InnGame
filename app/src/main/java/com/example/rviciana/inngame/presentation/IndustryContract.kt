package com.example.rviciana.inngame.presentation

import com.example.rviciana.inngame.domain.bo.Industry
import com.example.rviciana.inngame.domain.bo.Resources
import com.example.rviciana.inngame.domain.bo.Trailer

interface IndustryContract {

    interface View {
        fun showResources(resources: Resources)
        fun updateClock(timer: String)
        fun updateFactoryLevel(level: String)
        fun addTrailer(trailer: Trailer)
        fun showError(throwable: Throwable)
    }

    interface Presenter {
        fun setView(view: IndustryContract.View)
        fun onViewReady()
        fun onStop()
    }
}