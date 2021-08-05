package com.example.swensonhe_challenge.core.di

import com.example.swensonhe_challenge.core.AppConstants
import com.example.swensonhe_challenge.core.RetrofitServiceGenerator
import com.example.swensonhe_challenge.data.repository.FixerRepositoryImpl
import com.example.swensonhe_challenge.data.source.remote.FixerAPIService
import com.example.swensonhe_challenge.domain.repository.FixerRepository
import dagger.Module
import dagger.Provides


@Module
class CurrenciesModule {

    @Provides
    fun provideFixerAPIService(): FixerAPIService =
        RetrofitServiceGenerator().createService(
            FixerAPIService::class.java,
            AppConstants.FIXER_API_BASE_URL
        )

    @Provides
    fun provideFixerRepository(fixerRepositoryImpl: FixerRepositoryImpl): FixerRepository =
        fixerRepositoryImpl


}