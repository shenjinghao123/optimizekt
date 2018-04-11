package top.horsttop.appcore.ui.base

/**
 * Created by horsttop on 22/11/2017.
 */
interface MvpView {

    fun onLoading (tip:String = "")

    fun onDataError (error:String = "")

    fun onNetworkError()

}