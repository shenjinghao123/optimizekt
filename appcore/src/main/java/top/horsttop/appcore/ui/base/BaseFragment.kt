package top.horsttop.appcore.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import top.horsttop.appcore.core.GenApplication


/**
 * Created by horsttop on 15/12/30.
 */
abstract class BaseFragment<V : MvpView, out P : BasePresenter<V>> : Fragment(), MvpView {
    /**
     * 引入布局文件
     * @return
     */
    protected abstract val contentViewId: Int

    protected lateinit var rootView: View

    protected var mPresenter: BasePresenter<V>? = null


    /**
     * 界面初始化操作
     */
    protected abstract fun initViews()

    /**
     * 获取MvpView 实现MvpView的子类接口,方法体中 return this 即可
     * @return
     */
    protected abstract fun obtainMvpView(): V

    /**
     * 获取Presenter 引入Presenter,在方法体中给mPresenter赋值
     * @return
     */
    protected abstract fun obtainPresenter(): P


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        obtainPresenter()
        if (null != mPresenter)
            mPresenter!!.attachView(obtainMvpView())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        try {
            rootView = inflater.inflate(contentViewId, container, false)


        } catch (e: NullPointerException) {
            e.printStackTrace()
        } catch (e: Exception) {
            throw BaseActivity.InitViewException(e.message!!)
        }

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onDestroy() {
        mPresenter!!.detachView()
        super.onDestroy()

    }

}
