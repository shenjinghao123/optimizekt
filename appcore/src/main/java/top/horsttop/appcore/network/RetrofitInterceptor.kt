package top.horsttop.appcore.network

import android.util.Base64
import android.util.Log


import org.json.JSONException
import org.json.JSONObject

import java.io.IOException

import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.ResponseBody
import top.horsttop.appcore.BuildConfig

/**
 * Created by horsttop on 2018/4/13.
 * Interceptor for Retrofit to add auth key to header
 */
class RetrofitInterceptor : Interceptor {

    companion object {
         var token: String? = null
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        if (token == null) {
            val body = chain.proceed(getToken()).body()

            try {
                val jsonObject = JSONObject(body!!.string())
                token = "Bearer " + jsonObject.optString("access_token")
            } catch (e: JSONException) {
                e.printStackTrace()
                Log.d(RetrofitInterceptor::class.java.name, "Error fetching token")
            }

        }

        request = request.newBuilder()
                .addHeader("Authorization", token!!)
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
                .header("User-Agent", "My Twitter App v1.0.23")
                .header("Content-type", "application/x-www-form-urlencoded;charset=UTF-8")
                .build()
    }
}
