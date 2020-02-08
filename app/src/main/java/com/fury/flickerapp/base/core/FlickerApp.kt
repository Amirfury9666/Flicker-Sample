package com.fury.flickerapp.base.core

import android.app.Application
import androidx.lifecycle.ViewModel
import com.fury.flickerapp.ViewModelFactory
import com.fury.flickerapp.base.network.ConnectivityInterceptor
import com.fury.flickerapp.base.network.ConnectivityInterceptorImpl
import com.fury.flickerapp.base.network.ServiceGenerator
import com.fury.flickerapp.datasource.FlickerDataSource
import com.fury.flickerapp.datasource.FlickerDataSourceImpl
import com.fury.flickerapp.db.FlickerDatabase
import com.fury.flickerapp.repository.FlickerRepository
import com.fury.flickerapp.repository.FlickerRepositoryImpl
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class FlickerApp : Application() , KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@FlickerApp))
        bind() from singleton { FlickerDatabase(instance()) }
        bind() from singleton { instance<FlickerDatabase>().getFlickerDao()}
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { ServiceGenerator(instance()) }
        bind<FlickerDataSource>() with singleton { FlickerDataSourceImpl(instance()) }
        bind<FlickerRepository>() with singleton { FlickerRepositoryImpl(instance(),instance()) }
        bind() from provider { ViewModelFactory(instance()) }
    }
}