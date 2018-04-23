package top.horsttop.optimizedkt.ui.activity

import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import top.horsttop.appcore.ui.base.BaseActivity
import top.horsttop.appcore.util.PreferencesHelper
import top.horsttop.optimizedkt.R
import top.horsttop.optimizedkt.ui.mvpview.TestMvpView
import top.horsttop.optimizedkt.ui.presenter.TestPresenter
import javax.inject.Inject

/**
 * Created by horsttop on 2018/4/18.
 */
class TestActivity : BaseActivity<TestMvpView,TestPresenter>(),TestMvpView {
    @Inject
    lateinit var preferencesHelper: PreferencesHelper

    override fun initData(str: String?) {
        sample_text.text = str
    }

    override fun initViews() {

        Timber.d("xxxx")
        preferencesHelper.saveConfig("test","xxx")
        (mPresenter as TestPresenter).fetchData()
        sample_text.text = preferencesHelper.getStringConfig("test")
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