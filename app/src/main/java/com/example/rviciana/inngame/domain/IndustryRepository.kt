package com.example.rviciana.inngame.domain

import com.example.rviciana.inngame.domain.bo.Industry
import com.example.rviciana.inngame.domain.bo.Resources
import io.reactivex.Observable
import io.reactivex.Single

interface IndustryRepository {

    fun clock(): Observable<String>

    fun supplyResources(): Observable<Industry>
}