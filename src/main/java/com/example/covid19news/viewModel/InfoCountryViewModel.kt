package com.example.covid19news.viewModel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.covid19news.model.Model
import com.example.covid19news.networks.repositories.Repository

class InfoCountryViewModel(application: Application): AndroidViewModel(application) {
    //ObservableField: memperbarui data
    var isLoading: ObservableField<Boolean> = ObservableField()
    // mengupdate pengamat komponen aplikasi yang dalam status siklus proses aktif.
    var cekCountryResponse: MutableLiveData<Model> = MutableLiveData()
    var error: MutableLiveData<Throwable> = MutableLiveData()

    private var mainRepository = Repository()

}