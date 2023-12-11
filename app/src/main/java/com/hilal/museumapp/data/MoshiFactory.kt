package com.hilal.museumapp.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object MoshiFactory {

    fun build(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}