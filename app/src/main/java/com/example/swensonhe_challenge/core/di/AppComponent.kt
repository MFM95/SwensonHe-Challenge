package com.example.swensonhe_challenge.core.di

import android.app.Application
import com.example.swensonhe_challenge.core.CurrencyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class]
)
interface AppComponent {
    fun inject(app: CurrencyApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }
}