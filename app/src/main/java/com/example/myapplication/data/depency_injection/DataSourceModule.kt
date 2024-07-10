package com.example.myapplication.data.depency_injection

import com.example.myapplication.data.datasource.ClientDataSource
import com.example.myapplication.data.network.ClientServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun providesDataSourceModule(
        api: ClientServices
    ): ClientDataSource {
        return ClientDataSource(api)
    }
}