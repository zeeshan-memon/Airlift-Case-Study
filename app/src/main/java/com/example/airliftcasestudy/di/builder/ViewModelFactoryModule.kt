package com.example.airliftcasestudy.di.builder

import androidx.lifecycle.ViewModelProvider
import com.example.airliftcasestudy.ui.gallery.GalleryViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    /**
     *  This module basically says
     * inject this object into a Map using the @IntoMap annotation,
     * with the  ViewModels as key,
     * and a Provider that will build a tViewModelsFactory
     * object.
     */
    @Binds
    abstract fun bindMainViewModelFactory(factory: GalleryViewModelFactory): ViewModelProvider.Factory



}