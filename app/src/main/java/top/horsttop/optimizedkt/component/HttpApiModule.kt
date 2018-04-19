package top.horsttop.optimizedkt.component

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import top.horsttop.optimizedkt.model.api.HttpApi
import javax.inject.Singleton

/**
 * Created by horsttop on 2018/4/19.
 */
@Module
class HttpApiModule{

    @Provides
    @Singleton
    fun ofRetrofit(retrofit: Retrofit) : HttpApi = retrofit.create(HttpApi::class.java)
}