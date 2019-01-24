package com.example.rviciana.inngame.presentation

import com.example.rviciana.inngame.domain.GenerateResourcesUseCase
import com.example.rviciana.inngame.domain.GetClockUseCase
import com.example.rviciana.inngame.domain.bo.Industry

class IndustryPresenter(private val clockUseCase: GetClockUseCase,
                        private val generateResourcesUseCase: GenerateResourcesUseCase
): IndustryContract.Presenter {

    internal lateinit var view: IndustryContract.View

    override fun setView(view: IndustryContract.View) {
        this.view = view
    }

    override fun onViewReady() {
        clockUseCase.execute(::onClockSuccess, ::onError)
        generateResourcesUseCase.execute(::onGetResourcesSuccess, ::onError)
    }

    override fun onStop() {
        clockUseCase.dispose()
        generateResourcesUseCase.dispose()
    }

    internal fun onClockSuccess(timer: String) {
        view.updateClock(timer)
    }

    internal fun onGetResourcesSuccess(industry: Industry) {
        val resources = industry.resources
        view.showResources(resources)

        if (industry.level < 4) {
            val craftResources = industry.craftCost.resources
            if (resources.metal >= craftResources.metal &&
                    resources.fibre >= craftResources.fibre) {
                // Start industry update
            }
        } else {
            // Start to build trailers if have materials
        }
    }

    internal fun onError(throwable: Throwable) {
        view.showError(throwable)
    }

}