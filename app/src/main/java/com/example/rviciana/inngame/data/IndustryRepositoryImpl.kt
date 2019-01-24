package com.example.rviciana.inngame.data

import com.example.rviciana.inngame.domain.IndustryRepository
import com.example.rviciana.inngame.domain.bo.Resources
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class IndustryRepositoryImpl(private val industryDataSource: IndustryDataSource,
                             private val industryResourcesMapper: IndustryResourcesMapper,
                             private val clockMapper: ClockMapper
) : IndustryRepository {

    override fun clock(): Single<String> {
        return Single.timer(1, TimeUnit.SECONDS).map { clockMapper.map(it) }
    }

    override fun supplyResources(): Single<Resources> {
        return Single.just(industryDataSource.availableResources())
                .delay(1, TimeUnit.MINUTES)
                .map { industryResourcesMapper.map(it) }
    }

}