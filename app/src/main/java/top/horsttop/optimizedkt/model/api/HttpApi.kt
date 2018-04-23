package top.horsttop.optimizedkt.model.api

import io.reactivex.Observable
import retrofit2.http.GET
import top.horsttop.optimizedkt.pojo.MsgVo

/**
 * Created by horsttop on 2018/4/19.
 */
interface HttpApi {

    @GET("optimizedkt")
    fun fetchMsg(): Observable<MsgVo>
}