package top.horsttop.optimizedkt.component

import android.app.Application
import dagger.Component
import top.horsttop.appcore.component.IAppGraph
import top.horsttop.appcore.module.AppModule
import javax.inject.Singleton

/**
 * Created by horsttop on 2018/4/13.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent : IAppGraph{

    fun inject(application: Application)

}