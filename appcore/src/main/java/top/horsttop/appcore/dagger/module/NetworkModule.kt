package top.horsttop.appcore.dagger.module

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import top.horsttop.appcore.BuildConfig
import top.horsttop.appcore.network.RetrofitInterceptor
import javax.inject.Singleton

/**
 * Created by horsttop on 2018/4/13.
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun ofMoshi(): Moshi {
        return Moshi.Builder()
                // Add any other JsonAdapter factories.
                .add(KotlinJsonAdapterFactory())
                .build()
    }

    @Provides
    @Singleton
    internal fun ofOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(RetrofitInterceptor())
                .addInterceptor(HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
    }

    @Provides
    @Singleton
    internal fun ofMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory {
        return MoshiConverterFactory.create(moshi)
    }

    @Provides
    @Singleton
    internal fun ofRetrofit(okHttpClient: OkHttpClient, factory: MoshiConverterFactory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.END_POINT)
                .client(okHttpClient)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}