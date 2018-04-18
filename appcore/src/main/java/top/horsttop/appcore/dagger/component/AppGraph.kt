package top.horsttop.appcore.dagger.component

import dagger.Component
import top.horsttop.appcore.dagger.module.ApplicationModule
import top.horsttop.appcore.dagger.module.NetworkModule
import top.horsttop.appcore.dagger.runtime.PerActivity
import top.horsttop.appcore.ui.base.IPresenter
import top.horsttop.appcore.ui.base.MvpView

/**
 * Created by horsttop on 2018/4/18.
 */

@PerActivity
@Component(modules = arrayOf(ApplicationModule::class, NetworkModule::class))
interface AppGraph{

    fun inject(presenter : IPresenter)

    fun inject(mvpView: MvpView)

}