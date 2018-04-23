package top.horsttop.optimizedkt.ui.presenter

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import top.horsttop.appcore.ui.base.BasePresenter
import top.horsttop.optimizedkt.core.App
import top.horsttop.optimizedkt.model.api.HttpApi
import top.horsttop.optimizedkt.ui.mvpview.TestMvpView
import javax.inject.Inject

/**
 * Created by horsttop on 2018/4/18.
 */
class TestPresenter @Inject constructor(var api: HttpApi) : BasePresenter<TestMvpView>() {

    fun fetchData() {
        api.fetchMsg()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mvpView?.initData(it.msg)
                })
    }

}