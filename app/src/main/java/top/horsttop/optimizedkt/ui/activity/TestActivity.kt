package top.horsttop.optimizedkt.ui.activity

import android.view.View
import top.horsttop.appcore.ui.base.BaseActivity
import top.horsttop.optimizedkt.R
import top.horsttop.optimizedkt.ui.mvpview.TestMvpView
import top.horsttop.optimizedkt.ui.presenter.TestPresenter

/**
 * Created by horsttop on 2018/4/18.
 */
class TestActivity : BaseActivity<TestMvpView,TestPresenter>(),TestMvpView {
    override fun initViews() {

    }

    override fun obtainMvpView(): TestMvpView = this

    override fun onClick(v: View?) {

    }

    override val contentViewId: Int
        = R.layout.activity_main
    override fun obtainPresenter(): TestPresenter {
        mPresenter = TestPresenter()
        return mPresenter as TestPresenter
    }


}