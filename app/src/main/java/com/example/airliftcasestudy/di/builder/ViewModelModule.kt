package com.example.airliftcasestudy.di.builder

import androidx.lifecycle.ViewModel
import com.example.airliftcasestudy.di.annotation.ViewModelKey
import com.example.airliftcasestudy.ui.gallery.GalleryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    /**
     *  This module basically says
     * inject this object into a Map using the @IntoMap annotation,
     * with the  ViewModels as key,
     * and a Provider that will build a tViewModels
     * object.
     */

    @Binds
    @IntoMap
    @ViewModelKey(GalleryViewModel::class)
    abstract fun bindMainViewModel(viewModel: GalleryViewModel): ViewModel

}