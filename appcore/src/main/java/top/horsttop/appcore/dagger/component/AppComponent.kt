package top.horsttop.appcore.dagger.component

import android.app.Application
import com.squareup.moshi.Moshi
import dagger.Component
import dagger.Module
import retrofit2.Retrofit
import top.horsttop.appcore.dagger.module.AppModule
import top.horsttop.appcore.dagger.module.NetworkModule
import javax.inject.Singleton

/**
 * Created by horsttop on 2018/4/19.
 */
@Singleton
@Component (modules = arrayOf(AppModule::class,NetworkModule::class))
interface AppComponent{
    fun application():Application

    fun moshi():Moshi

    fun retrofit():Retrofit


}