package com.example.runworkshop.di

import com.example.runworkshop.data.model.network.ConsultoraApiClient
import com.example.runworkshop.data.model.network.InstitutoApiClient
import com.example.runworkshop.data.model.network.UniversidadApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/*Este modulo nos va a proveer dependencias y librerias que no sean tan faciles de proveer,
o dependencias de clases que contengan interfaces */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.1.7:9090/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideInstitutoApiClient(retrofit: Retrofit): InstitutoApiClient {
        return retrofit.create(InstitutoApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideConsultoraApiClient(retrofit: Retrofit): ConsultoraApiClient {
        return retrofit.create(ConsultoraApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideUniversidadApiClient(retrofit: Retrofit): UniversidadApiClient {
        return retrofit.create(UniversidadApiClient::class.java)
    }
}