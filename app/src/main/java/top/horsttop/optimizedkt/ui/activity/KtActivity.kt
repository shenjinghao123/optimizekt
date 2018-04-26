package top.horsttop.optimizedkt.ui.activity

import android.os.Bundle
import android.view.View
import top.horsttop.appcore.ui.base.BaseActivity
import top.horsttop.optimizedkt.R
import top.horsttop.optimizedkt.core.App
import top.horsttop.optimizedkt.di.component.DaggerActivityComponent
import top.horsttop.optimizedkt.di.module.ActivityModule
import top.horsttop.optimizedkt.ui.mvpview.KtMvpView
import top.horsttop.optimizedkt.ui.presenter.KtPresenter
import javax.inject.Inject

/**
 * Created by horsttop on 2018/4/26.
 */
class KtActivity : BaseActivity(), KtMvpView {
    override val contentViewId: Int
        = R.layout.activity_test

    override fun initViews() {
    }

    override fun onClick(v: View?) {
    }

    @Inject
    lateinit var mPresenter: KtPresenter

    override fun onActivityInject() {
        DaggerActivityComponent.builder()
                .appComponent(App.appComponent)
                .activityModule(ActivityModule())
                .build()
                .inject(this)
        mPresenter.attachView(this)
    }


}