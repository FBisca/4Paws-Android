package com.fourpaws.di

import com.fourpaws.App
import com.fourpaws.di.modules.ActivityBindModule
import dagger.Component
import dagger.MembersInjector
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ActivityBindModule::class))
interface ApplicationComponent : MembersInjector<App>
