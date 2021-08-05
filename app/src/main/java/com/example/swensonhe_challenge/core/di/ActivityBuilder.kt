package com.example.swensonhe_challenge.core.di

import com.example.swensonhe_challenge.presentation.view.CurrenciesActivity
import com.example.swensonhe_challenge.presentation.view.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [CurrenciesModule::class])
    abstract fun bindHomeActivity(): HomeActivity

    @ContributesAndroidInjector(modules = [CurrenciesModule::class, FragmentBuilder::class])
    abstract fun bindCurrenciesActivity(): CurrenciesActivity
}