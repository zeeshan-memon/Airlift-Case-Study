package com.example.airliftcasestudy

import android.annotation.SuppressLint
import com.example.airliftcasestudy.di.component.AppComponent
import com.example.airliftcasestudy.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

@SuppressLint("Registered")
/**
 * Kotlin    Application.
 * It's necessary for dagger injection
 */
class DaggerApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        /**
         * Build app component
         */
        val appComponent: AppComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        /**inject application instance**/
        appComponent.inject(this)
        return appComponent
    }

    companion object {
        private var sInstance: DaggerApp? = null
        fun getAppContext(): DaggerApp? {
            return sInstance
        }
    }

    override fun onCreate() {
        super.onCreate()
        sInstance = this

    }

}