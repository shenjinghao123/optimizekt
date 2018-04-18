package top.horsttop.appcore.component

import dagger.Component
import top.horsttop.appcore.module.ApplicationModule
import top.horsttop.appcore.module.NetworkModule
import top.horsttop.appcore.ui.base.BasePresenter
import top.horsttop.appcore.ui.base.IPresenter
import top.horsttop.appcore.ui.base.MvpView
import top.horsttop.appcore.ui.base.Presenter
import javax.inject.Singleton

/**
 * Created by horsttop on 2018/4/18.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class,NetworkModule::class))
interface AppGraph{

    fun inject(presenter : IPresenter)

    fun inject(mvpView: MvpView)

}