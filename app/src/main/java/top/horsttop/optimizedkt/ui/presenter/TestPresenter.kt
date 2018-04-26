package top.horsttop.optimizedkt.ui.presenter

import io.reactivex.functions.Consumer
import top.horsttop.appcore.extention.runOnMainThread
import top.horsttop.appcore.extention.subscribeX
import top.horsttop.appcore.ui.base.BasePresenter
import top.horsttop.optimizedkt.model.api.HttpApi
import top.horsttop.optimizedkt.ui.mvpview.TestMvpView
import javax.inject.Inject

/**
 * Created by horsttop on 2018/4/18.
 */
class TestPresenter @Inject constructor(var api: HttpApi) : BasePresenter<TestMvpView>() {

    fun fetchData() {
        mvpView?.onLoading()
        val subscription = api.fetchMsg()
                .runOnMainThread()
                .subscribeX(Consumer{ it ->
                    mvpView?.onPageSuccess()
                    mvpView?.initData(it.msg)
                },mvpView)
        mCompositeDisposable?.add(subscription)
    }



}