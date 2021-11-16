package com.example.covid19news.networks.repositories

import com.example.covid19news.model.CountriesItem
import com.example.covid19news.model.Model
import com.example.covid19news.networks.ApiObserver
import com.example.covid19news.networks.ServiceFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class Repository {
    // memudahkan clear satu atau banyak proses background thread yang dalam hal ini proses http request.
    private val compositeDisposable = CompositeDisposable()
    private val apiService = ServiceFactory.create()

    fun getWorld(
        onResult: (Model) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        apiService.getAllCountry()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiObserver<Model>(compositeDisposable) {
                override fun onApiSuccess(data: Model) {
                    onResult(data)
                }

                override fun onApiError(er: Throwable) {
                    onError(er)
                }
            })
    }

    fun getEachCountries(
        onResult: (CountriesItem) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        apiService.getEachCountry()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiObserver<CountriesItem>(compositeDisposable) {
                override fun onApiSuccess(data: CountriesItem) {
                    onResult(data)
                }

                override fun onApiError(er: Throwable) {
                    onError(er)
                }
            })
    }

    fun cleared() {
        compositeDisposable.clear()
    }
}