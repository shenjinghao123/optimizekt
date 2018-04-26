package top.horsttop.optimizedkt.di.component

import dagger.Component
import top.horsttop.appcore.dagger.runtime.PerActivity
import top.horsttop.optimizedkt.di.module.ActivityModule
import top.horsttop.optimizedkt.ui.activity.KtActivity
import top.horsttop.optimizedkt.ui.activity.TestActivity

/**
 * Created by horsttop on 2018/4/23.
 */
@PerActivity
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(testActivity: TestActivity)
    fun inject(testActivity: KtActivity)

}