package top.horsttop.appcore.network

import android.app.Application
import android.content.Context
import android.util.Base64
import android.util.Log
import dagger.Module
import okhttp3.*


import org.json.JSONException
import org.json.JSONObject

import java.io.IOException

import top.horsttop.appcore.BuildConfig
import top.horsttop.appcore.core.GenApplication
import top.horsttop.appcore.util.net.NetWorkUtil
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by horsttop on 2018/4/13.
 * Interceptor for Retrofit to add auth key to header
 */

class RetrofitInterceptor(var context:Context) : Interceptor {

    companion object {
         var token: String = "asdf"
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response ?{


        var request = chain.request()
        val requestBuilder = request.newBuilder()
                .method(request.method(), request.body())
        requestBuilder.cacheControl(CacheControl.FORCE_CACHE)
        if(!NetWorkUtil.isNetworkConnected(context)){
            throw NetworkErrorException()
        }

        request = request.newBuilder()
                .addHeader("Authorization", token)
                .build()

        return chain.proceed(request)
    }

    private fun getToken(): Request {
        val bearerToken = BuildConfig.CONSUMER_KEY +
                ":" + BuildConfig.CONSUMER_SECRET

        val base64BearerToken = "Basic " + Base64.encodeToString(bearerToken.toByteArray(), Base64.NO_WRAP)
        val requestBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8"), "grant_type=client_credentials")

        return Request.Builder()
                .url(BuildConfig.AUTH_END_POINT)
                .post(requestBody)
                .header("Authorization", base64BearerToken)
                .header("Content-Encoding", "gzip")
                .header("User-Agent", "horsttop")
                .header("Content-type", "application/x-www-form-urlencoded;charset=UTF-8")
                .build()
    }

//    Authorization


    class NetworkErrorException() : RuntimeException()
}
