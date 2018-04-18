package top.horsttop.appcore.core

import android.app.Application
import top.horsttop.appcore.component.AppGraph
import top.horsttop.appcore.component.DaggerAppGraph
import top.horsttop.appcore.module.ApplicationModule
import top.horsttop.appcore.module.NetworkModule

/**
 * Created by horsttop on 2018/4/13.
 */
open class GenApplication : Application(){

    companion object {
        //platformStatic allow access it from java code
        @JvmStatic  var appGraph: AppGraph ?= null
        @JvmStatic  lateinit var appGraphBuilder: DaggerAppGraph.Builder
    }

    override fun onCreate() {
        super.onCreate()
        appGraphBuilder = DaggerAppGraph.builder()


    }

}