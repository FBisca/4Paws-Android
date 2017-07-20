package com.fourpaws

import android.app.Application
import com.fourpaws.di.arch.ActivityInjectorFactory
import javax.inject.Inject

class App : Application() {

    @Inject
    lateinit var activityInjector: ActivityInjectorFactory
}
