package com.example.rviciana.inngame.presentation

import com.example.rviciana.inngame.domain.GenerateResourcesUseCase
import com.example.rviciana.inngame.domain.GetClockUseCase
import com.example.rviciana.inngame.domain.bo.Resources

class IndustryPresenter(private val clockUseCase: GetClockUseCase,
                        private val generateResourcesUseCase: GenerateResourcesUseCase
): IndustryContract.Presenter {

    internal lateinit var view: IndustryContract.View

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

    internal fun onGetResourcesSuccess(resources: Resources) {
        view.showResources(resources)

        
    }

    internal fun onError(throwable: Throwable) {
        view.showError(throwable)
    }

}