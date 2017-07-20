package com.fourpaws.di.modules

import com.fourpaws.app.home.HomeActivity
import com.fourpaws.app.home.HomeSubcomponent
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ActivityBindModule {

    @Binds
    @IntoMap
    @ClassKey(HomeActivity::class)
    abstract fun providesHomeSubcomponent(homeSubcomponent: HomeSubcomponent.Builder)
}
