package top.horsttop.appcore.core

import android.app.Application
import timber.log.Timber
import top.horsttop.appcore.BuildConfig
import top.horsttop.appcore.dagger.component.AppComponent
import top.horsttop.appcore.dagger.component.DaggerAppComponent
import top.horsttop.appcore.dagger.module.AppModule

/**
 * Created by horsttop on 2018/4/13.
 */
open class GenApplication : Application(){

    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        initDagger()
    }


    private fun initDagger() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

}