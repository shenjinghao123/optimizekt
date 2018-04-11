package top.horsttop.appcore.extention

import android.content.Context
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat

/**
 * Created by horsttop on 2018/4/11.
 */

/**
 * 获取颜色
 */
fun Context.ofColor(@ColorRes id : Int) : Int{
    return ContextCompat.getColor(this, id)
}

