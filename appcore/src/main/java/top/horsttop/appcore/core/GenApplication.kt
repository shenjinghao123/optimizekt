package top.horsttop.appcore.core

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import timber.log.Timber
import top.horsttop.appcore.BuildConfig
import top.horsttop.appcore.dagger.component.CoreComponent
import top.horsttop.appcore.dagger.component.DaggerCoreComponent
import top.horsttop.appcore.dagger.module.ApplicationModule
import top.horsttop.appcore.load.callback.EmptyCallback
import top.horsttop.appcore.load.callback.ErrorCallback
import top.horsttop.appcore.load.callback.LoadingCallback
import top.horsttop.appcore.load.callback.TimeoutCallback
import top.horsttop.appcore.load.core.Loader

/**
 * Created by horsttop on 2018/4/13.
 */
open class GenApplication : Application() {

    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit var coreComponent: CoreComponent
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        initDagger()

        Loader.beginBuilder()
                .addCallback(ErrorCallback())
                .addCallback(EmptyCallback())
                .addCallback(LoadingCallback())
                .addCallback(TimeoutCallback())
                .setDefaultCallback(LoadingCallback::class.java)
                .commit()

    }


    private fun initDagger() {
        coreComponent = DaggerCoreComponent.builder().applicationModule(ApplicationModule(this)).build()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}