package top.horsttop.optimizedkt.ui.activity

import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import top.horsttop.appcore.extention.ofColor
import top.horsttop.appcore.ui.base.BaseActivity
import top.horsttop.appcore.util.PreferencesHelper
import top.horsttop.appcore.util.net.NetChangeObserver
import top.horsttop.appcore.util.net.NetWorkUtil
import top.horsttop.appcore.util.net.NetworkStateReceiver
import top.horsttop.optimizedkt.R
import top.horsttop.optimizedkt.core.App
import top.horsttop.optimizedkt.di.component.DaggerActivityComponent
import top.horsttop.optimizedkt.di.module.ActivityModule
import top.horsttop.optimizedkt.ui.mvpview.TestMvpView
import top.horsttop.optimizedkt.ui.presenter.TestPresenter
import javax.inject.Inject

/**
 * Created by horsttop on 2018/4/18.
 */
class TestActivity : BaseActivity<TestMvpView,TestPresenter>(),TestMvpView {
    override fun onActivityInject() {
//        DaggerActivityComponent.builder()
//                .appComponent(App.appComponent)
//                .activityModule(ActivityModule())
//                .build()
//                .inject(this)
//        mPresenter.attachView(this)
        DaggerActivityComponent.builder()
                .appComponent(App.appComponent)
                .activityModule(ActivityModule())
                .build()
                .inject(this)
        mPresenter.attachView(this)


    }

    @Inject
    lateinit var mPresenter: TestPresenter

    override fun initData(str: String?) {
        sample_text.text = str
        NetworkStateReceiver.registerObserver( object :NetChangeObserver{
            override fun onConnect(type: NetWorkUtil.NetType) {
                Timber.i("onConnect :${type.name}")
            }

            override fun onDisConnect() {
                Timber.i("onDisConnect")
            }

        })

    }



    override fun initViews() {
        Timber.d("xxxx")
        setUpLoadingArea(rl_content)

        mPresenter.fetchData()
    }

    override fun onStart() {
        super.onStart()
        NetworkStateReceiver.registerNetworkStateReceiver(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        NetworkStateReceiver.unRegisterNetworkStateReceiver(this)
    }




    override fun onClick(v: View?) {

    }

    override val contentViewId: Int
        = R.layout.activity_main

}