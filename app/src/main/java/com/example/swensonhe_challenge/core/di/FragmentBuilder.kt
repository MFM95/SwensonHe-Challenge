package com.example.swensonhe_challenge.core.di

import com.example.swensonhe_challenge.presentation.view.CalculatorFragment
import com.example.swensonhe_challenge.presentation.view.CurrenciesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = [])
    internal abstract fun provideLocalCurrenciesFragment(): CurrenciesFragment

    @ContributesAndroidInjector(modules = [])
    internal abstract fun provideCalculatorFragment(): CalculatorFragment

}