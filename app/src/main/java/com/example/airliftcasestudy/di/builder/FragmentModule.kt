package com.example.airliftcasestudy.di.builder

import com.example.airliftcasestudy.ui.gallery.GalleryFragment
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

@Module(includes = [AndroidInjectionModule::class])
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): GalleryFragment


}