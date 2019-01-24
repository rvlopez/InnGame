package com.example.rviciana.inngame.domain

import com.example.rviciana.inngame.domain.bo.Resources
import io.reactivex.Single

interface IndustryRepository {

    fun clock(): Single<String>

    fun supplyResources(): Single<Resources>
}