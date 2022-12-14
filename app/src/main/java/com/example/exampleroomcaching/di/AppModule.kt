package com.example.exampleroomcaching.di

import android.content.Context
import androidx.room.Room
import com.example.exampleroomcaching.data.local.PizzaDataBase
import com.example.exampleroomcaching.data.remote.PizzaService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(PizzaService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun providePizzaService(retrofit: Retrofit): PizzaService =
        retrofit.create(PizzaService::class.java)

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): PizzaDataBase =
        Room.databaseBuilder(context, PizzaDataBase::class.java, "pizza_database")
            .build()
}