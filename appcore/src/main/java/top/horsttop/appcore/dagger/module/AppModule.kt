package top.horsttop.appcore.dagger.module

import android.app.Application
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by horsttop on 2018/4/19.
 */
@Module
class AppModule(val application:Application){

    @Provides
    @Singleton
    fun ofApplication() = application

}