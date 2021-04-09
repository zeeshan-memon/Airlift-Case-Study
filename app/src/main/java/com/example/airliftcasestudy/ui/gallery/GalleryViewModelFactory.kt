package com.example.airliftcasestudy.ui.gallery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider



class GalleryViewModelFactory @Inject constructor(private val viewModelProvider: Provider<GalleryViewModel>) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return viewModelProvider.get() as T
    }
}