package top.horsttop.optimizedkt.core

import android.app.Application
import retrofit2.Retrofit
import top.horsttop.appcore.core.GenApplication
import top.horsttop.optimizedkt.model.api.HttpApi
import javax.inject.Inject

/**
 * Created by horsttop on 2018/4/13.
 */
class App : GenApplication(){



    @Inject
    lateinit var retrofit:Retrofit

    override fun onCreate() {
        super.onCreate()

//        appGraph = appGraphBuilder
        appGraph?.inject(this)
        httpApi = retrofit.create(HttpApi::class.java)

    }

    companion object {
        lateinit var httpApi:HttpApi
    }
}