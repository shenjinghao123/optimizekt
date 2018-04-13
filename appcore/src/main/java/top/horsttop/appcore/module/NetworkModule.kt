package top.horsttop.appcore.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import top.horsttop.appcore.BuildConfig
import javax.inject.Singleton

/**
 * Created by horsttop on 2018/4/13.
 */
//@Module
//class NetworkModule{
//
//
//    @Provides
//    @Singleton
//    internal fun provideGson(): Gson {
//        return GsonBuilder().serializeNulls().registerTypeAdapterFactory(AutoValueGsonFactory.create()).create()
//    }
//
//    @Provides
//    @Singleton
//    internal fun provideOkHttpClient(): OkHttpClient {
//        return OkHttpClient.Builder().addInterceptor(RetrofitInterceptor()).build()
//    }
//
//    @Provides
//    @Singleton
//    internal fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory {
//        return GsonConverterFactory.create(gson)
//    }
//
//    @Provides
//    @Singleton
//    internal fun provideRetrofit(okHttpClient: OkHttpClient, factory: GsonConverterFactory): Retrofit {
//        return Retrofit.Builder()
//                .baseUrl(BuildConfig.END_POINT)
//                .client(okHttpClient)
//                .addConverterFactory(factory)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build()
//    }
//}