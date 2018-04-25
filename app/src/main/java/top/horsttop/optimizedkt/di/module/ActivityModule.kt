package top.horsttop.optimizedkt.di.module

import dagger.Module
import dagger.Provides
import top.horsttop.appcore.dagger.runtime.PerActivity
import top.horsttop.optimizedkt.model.api.HttpApi
import top.horsttop.optimizedkt.ui.presenter.TestPresenter

/**
 * Created by horsttop on 2018/4/23.
 */

@Module
class ActivityModule {

    @Provides
    @PerActivity
    internal fun ofTestPresenter(api: HttpApi): TestPresenter {
        return TestPresenter(api)
    }


}