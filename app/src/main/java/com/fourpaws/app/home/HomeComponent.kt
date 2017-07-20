package com.fourpaws.app.home

import com.fourpaws.di.arch.ActivityComponent
import com.fourpaws.di.arch.ActivityModule
import dagger.Subcomponent

@Subcomponent
interface HomeComponent : ActivityComponent<HomeActivity> {
    @Subcomponent.Builder
    interface Builder : ActivityComponent<HomeActivity>

    class HomeModule(activity: HomeActivity) : ActivityModule(activity)
}
