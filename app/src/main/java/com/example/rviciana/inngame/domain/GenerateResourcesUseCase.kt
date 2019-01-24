package com.example.rviciana.inngame.domain

import com.example.rviciana.inngame.domain.bo.Resources
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables

class GenerateResourcesUseCase(private val industryRepository: IndustryRepository,
                               private val subscribeOn: Scheduler,
                               private val observeOn: Scheduler) {

    private var disposable: Disposable = Disposables.empty()

    fun execute(onComplete: (Resources) -> Unit, onError: (Throwable) -> Unit) {
        disposable = industryRepository.supplyResources()
                .subscribeOn(subscribeOn)
                .observeOn(observeOn)
                .subscribe(onComplete, onError)
    }

    fun dispose() {
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }
}