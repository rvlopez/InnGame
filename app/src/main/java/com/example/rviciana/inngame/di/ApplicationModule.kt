package com.example.rviciana.inngame.di

import com.example.rviciana.inngame.data.ClockMapper
import com.example.rviciana.inngame.data.IndustryDataSource
import com.example.rviciana.inngame.data.IndustryRepositoryImpl
import com.example.rviciana.inngame.data.IndustryResourcesMapper
import com.example.rviciana.inngame.domain.GenerateResourcesUseCase
import com.example.rviciana.inngame.domain.GetClockUseCase
import com.example.rviciana.inngame.domain.IndustryRepository
import com.example.rviciana.inngame.presentation.IndustryContract
import com.example.rviciana.inngame.presentation.IndustryPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.time.Clock
import javax.inject.Named

@Module
class ApplicationModule {

    @Provides
    @Named("observeOn")
    fun observeOnScheduler(): Scheduler = AndroidSchedulers.mainThread()

    @Provides
    @Named("subscribeOn")
    fun subscribeOnScheduler(): Scheduler = Schedulers.io()

    @Provides
    fun provideIndustryDataSource(): IndustryDataSource = IndustryDataSource()

    @Provides
    fun provideIndustryRepository(industryDataSource: IndustryDataSource,
                                  industryResourcesMapper: IndustryResourcesMapper,
                                  clockMapper: ClockMapper
    ): IndustryRepository = IndustryRepositoryImpl(industryDataSource, industryResourcesMapper, clockMapper)

    @Provides
    fun provideIndustryResourcesMapper(): IndustryResourcesMapper = IndustryResourcesMapper()

    @Provides
    fun provideClockMapper(): ClockMapper = ClockMapper()

    @Provides
    fun provideGenerateResourcesUseCase(industryRepository: IndustryRepository,
                                        @Named("subscribeOn") subscribeOn: Scheduler,
                                        @Named("observeOn") observeOn: Scheduler
    ): GenerateResourcesUseCase = GenerateResourcesUseCase(industryRepository, subscribeOn, observeOn)

    @Provides
    fun provideClockUseCase(industryRepository: IndustryRepository,
                            @Named("subscribeOn") subscribeOn: Scheduler,
                            @Named("observeOn") observeOn: Scheduler
    ): GetClockUseCase = GetClockUseCase(industryRepository, subscribeOn, observeOn)

    @Provides
    fun provideIndustryPresenter(clockUseCase: GetClockUseCase,
                                 generateResourcesUseCase: GenerateResourcesUseCase
    ): IndustryContract.Presenter = IndustryPresenter(clockUseCase, generateResourcesUseCase)


}