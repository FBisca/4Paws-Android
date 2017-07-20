package com.fourpaws.di.arch

import android.support.v4.app.Fragment
import javax.inject.Inject

@ActivityScope
class FragmentInjectorFactory @Inject constructor(
        private val componentBuilders: Map<Class<out Fragment>, @JvmSuppressWildcards FragmentComponent.Builder<out Fragment>>
) {

    fun builder(kClass: Class<*>): FragmentComponent.Builder<out Fragment> {
        return componentBuilders[kClass] ?:
                throw IllegalArgumentException("Could not find Subcomponent.Builder for class ${kClass.simpleName}")
    }
}
