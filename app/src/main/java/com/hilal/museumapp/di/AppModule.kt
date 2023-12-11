package com.hilal.museumapp.di

import com.hilal.museumapp.data.MoshiFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideMoshi(moshiFactory: MoshiFactory): Moshi {
        return moshiFactory.build()
    }
}
