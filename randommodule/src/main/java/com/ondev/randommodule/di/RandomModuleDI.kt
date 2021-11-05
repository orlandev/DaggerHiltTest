package com.ondev.randommodule.di

import com.ondev.randommodule.random.CRandom
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlin.random.Random

@Module
@InstallIn(SingletonComponent::class)
object RandomModuleDI {

    @Provides
    @Singleton
    fun randomKotlinClass(): Random = Random

    @Provides
    @Singleton
    fun provideCRandom(rand: Random): CRandom = CRandom(rand)

}