package top.horsttop.appcore.extention

import android.content.Context
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.internal.functions.Functions
import io.reactivex.internal.operators.flowable.FlowableInternalHelper
import io.reactivex.schedulers.Schedulers
import top.horsttop.appcore.ui.base.MvpView

/**
 * Created by horsttop on 2018/4/11.
 */

/**
 * 获取颜色
 */
fun Context.ofColor(@ColorRes id : Int) : Int{
    return ContextCompat.getColor(this, id)
}


/**
 * run on mainThread
 */
fun <T> Flowable<T>.runOnMainThread():Flowable<T>{
    return this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}

/**
 * super subscribe
 */
fun <T> Flowable<T>.subscribeX(onNext:Consumer<in T> ,mvpView: MvpView?=null):Disposable{
    return if(mvpView == null){
        subscribe(onNext, Consumer<Throwable> {

        }, Functions.EMPTY_ACTION, FlowableInternalHelper.RequestMax.INSTANCE)
    } else {
        subscribe(onNext, Consumer<Throwable> {
            mvpView.onDataError()
        }, Functions.EMPTY_ACTION, FlowableInternalHelper.RequestMax.INSTANCE)
    }


}