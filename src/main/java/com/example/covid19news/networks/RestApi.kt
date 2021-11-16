package com.example.covid19news.networks

import com.example.covid19news.model.CountriesItem
import com.example.covid19news.model.Model
import io.reactivex.Observable
import retrofit2.http.GET

interface RestApi {
    @GET("summary")
    fun getAllCountry(): Observable<Model>

    @GET("summary")
    fun getEachCountry(): Observable<CountriesItem>
}