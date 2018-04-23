package top.horsttop.appcore.ui.base

import io.reactivex.disposables.CompositeDisposable
import top.horsttop.appcore.core.GenApplication


/**
 * Presenter层的基础实现类
 * Created by horsttop on 15/12/30.
 */
open class BasePresenter<G : MvpView> : Presenter<G> {

    var mvpView: G? = null
        private set

    var mCompositeDisposable: CompositeDisposable? = null
        private set


    override fun attachView(mvpView: G) {
        if (null == mCompositeDisposable) {
            mCompositeDisposable = CompositeDisposable()
        }
        this.mvpView = mvpView
    }

    override fun detachView() {
        if (null != mCompositeDisposable) {
            mCompositeDisposable!!.clear()
        }

    }

    override fun clearSubscriptions() {
        mvpView = null
    }

}
