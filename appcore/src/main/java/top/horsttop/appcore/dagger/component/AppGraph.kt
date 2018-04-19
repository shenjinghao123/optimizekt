package top.horsttop.appcore.dagger.component

import android.app.Application
import dagger.Component
import top.horsttop.appcore.dagger.module.ApplicationModule
import top.horsttop.appcore.dagger.module.NetworkModule
import top.horsttop.appcore.ui.base.IPresenter
import top.horsttop.appcore.ui.base.MvpView
import javax.inject.Singleton

/**
 * Created by horsttop on 2018/4/18.
 */

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, NetworkModule::class))
interface AppGraph{

    fun inject(presenter : IPresenter)

    fun inject(mvpView: MvpView)

    fun inject(application: Application)

}