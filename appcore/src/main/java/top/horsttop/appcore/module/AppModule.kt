package top.horsttop.appcore.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import top.horsttop.appcore.util.PreferencesHelper
import javax.inject.Singleton

/**
 * Created by horsttop on 2018/4/13.
 */
@Module
class AppModule(private val application: Application){

    @Provides
    @Singleton
    fun ofAppContext(): Context = application


    @Provides
    @Singleton
    fun ofPreferencesHelper() : PreferencesHelper{
        return PreferencesHelper(application)
    }
}