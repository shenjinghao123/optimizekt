package top.horsttop.appcore.ui.base

import android.content.Context
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import top.horsttop.appcore.R
import top.horsttop.appcore.extention.ofColor
import top.horsttop.appcore.statusbar.StatusBarUtil

import java.lang.Exception
import java.lang.NullPointerException
import java.lang.RuntimeException


/**
 * Created by horsttop on 15/12/30.
 */
abstract class BaseActivity<V : MvpView, out P : BasePresenter<V>> : AppCompatActivity(), MvpView, View.OnClickListener {
    /**
     * 引入布局文件
     *
     * @return
     */
    protected abstract val contentViewId: Int

    protected var mPresenter: Presenter<V>? = null

    /**
     * 界面初始化操作
     */
    protected abstract fun initViews()

    /**
     * 获取MvpView 实现MvpView的子类接口,方法体中 return this 即可
     *
     * @return
     */
    protected abstract fun obtainMvpView(): V

    /**
     * 获取Presenter 引入Presenter,在方法体中给mPresenter赋值
     *
     * @return
     */
    protected abstract fun obtainPresenter(): P

    /**
     * 界面唤醒时需要的操作
     */
    protected open fun resumeViews() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
//            window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

            setContentView(contentViewId)
            initStatusBar()

//            GenApp.pushActivity(this)

//            mImm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

            obtainPresenter()
            if (null != mPresenter) {
                mPresenter!!.attachView(obtainMvpView())
            }
            initViews()
        } catch (e: NullPointerException) {
            e.printStackTrace()
        } catch (e: Exception) {
            //            Log.e(Constant.TAG, this.toString());
            throw InitViewException(e.message!!)
        }

    }

    protected fun initStatusBar() {
        StatusBarUtil.setColor(this, this.ofColor(R.color.colorPrimary))
    }

    override fun onResume() {
        super.onResume()
        resumeViews()
    }


    override fun onLoading(tip: String) {

    }

    override fun onDataError(error: String) {

    }

    override fun onNetworkError() {

    }

    override fun onStop() {
        super.onStop()
        if (mPresenter != null)
            mPresenter!!.clearSubscriptions()
    }

    override fun onDestroy() {
        super.onDestroy()
//        GenUIUtil.dropProgressDialog()

//        GenApp.popActivity(this)
        if (mPresenter != null)
            mPresenter!!.detachView()

    }

    class InitViewException(msg: String) : RuntimeException(msg)


}
