package com.example.rviciana.inngame.domain

import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables

class GetClockUseCase(private val industryRepository: IndustryRepository,
                      private val subscribeOn: Scheduler,
                      private val observeOn: Scheduler) {

    private var disposable: Disposable = Disposables.empty()

    fun execute(onComplete: (String) -> Unit, onError: (Throwable) -> Unit) {
        disposable = industryRepository.clock()
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