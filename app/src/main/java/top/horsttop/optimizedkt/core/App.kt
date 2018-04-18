package top.horsttop.optimizedkt.core

import android.app.Application
import top.horsttop.appcore.core.GenApplication

/**
 * Created by horsttop on 2018/4/13.
 */
class App : GenApplication(){


    override fun onCreate() {
        super.onCreate()
        appGraphBuilder.build()
    }
}