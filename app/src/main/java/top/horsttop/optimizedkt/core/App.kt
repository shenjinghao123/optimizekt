package top.horsttop.optimizedkt.core

import timber.log.Timber
import top.horsttop.appcore.core.GenApplication
import top.horsttop.optimizedkt.di.component.AppComponent
import top.horsttop.optimizedkt.di.component.DaggerAppComponent
import top.horsttop.optimizedkt.di.module.ApiModule
import top.horsttop.optimizedkt.model.api.HttpApi

/**
 * Created by horsttop on 2018/4/13.
 */
class App : GenApplication(){


    override fun onCreate() {
        super.onCreate()

//        appGraph = appGraphBuilder
        Timber.d("to inject")
//        appGraph?.inject(this)
//        httpApi = retrofit.create(HttpApi::class.java)
        appComponent = DaggerAppComponent.builder()
                .coreComponent(coreComponent)
                .build()
        appComponent.inject(this)

    }

    companion object {

        @JvmStatic lateinit var appComponent: AppComponent
    }

}