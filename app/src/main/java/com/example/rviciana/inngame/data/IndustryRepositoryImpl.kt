package com.example.rviciana.inngame.data

import com.example.rviciana.inngame.domain.IndustryRepository
import com.example.rviciana.inngame.domain.bo.Industry
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class IndustryRepositoryImpl(private val industryDataSource: IndustryDataSource,
                             private val industryResourcesMapper: IndustryResourcesMapper,
                             private val clockMapper: ClockMapper
) : IndustryRepository {

    override fun clock(): Observable<String> {
        return Observable.interval(1, TimeUnit.SECONDS)
                .map { second -> clockMapper.map(second + 1) }
    }

    override fun supplyResources(): Observable<Industry> {
        return Observable.interval(1, TimeUnit.MINUTES)
                .map {
                    industryDataSource.addResources()
                    industryResourcesMapper.map(industryDataSource.availableResources())
                }
    }

}