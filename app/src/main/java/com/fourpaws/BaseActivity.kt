package com.fourpaws

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.fourpaws.di.arch.ActivityComponent
import com.fourpaws.di.arch.ActivityModule
import com.fourpaws.di.arch.FragmentInjectorFactory
import dagger.Lazy
import javax.inject.Inject

abstract class BaseActivity<out M: ActivityModule> : AppCompatActivity() {

    @Inject
    lateinit var fragmentInjectionFactory: Lazy<FragmentInjectorFactory>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject(this, instantiateModule(savedInstanceState))
    }

    abstract fun instantiateModule(savedInstanceState: Bundle?): M

    open protected fun <B : ActivityComponent.Builder<T, M>, M : ActivityModule, T : Activity> injectMembers(instance: T, builder: B, module: M) {
        builder.module(module)
                .build()
                .injectMembers(instance)
    }

    open protected fun getComponentBuilder(): ActivityComponent.Builder<out Activity, *> {
        val app = application as App
        return app.activityInjector.builder(javaClass)
    }

    protected inline fun <reified T : Fragment> findFragment(): T? {
        return supportFragmentManager.findFragmentByTag(T::class.java.simpleName) as? T
    }

    protected inline fun <reified B : ActivityComponent.Builder<T, M>, M: ActivityModule, T: Activity> inject(instance: T, module: M) {
        val builder = getComponentBuilder() as? B ?: throw IllegalArgumentException("Could not cast component builder")
        injectMembers(instance, builder, module)
    }
}
