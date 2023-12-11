package com.hilal.museumapp.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoshiFactory @Inject constructor() {

    fun build(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}