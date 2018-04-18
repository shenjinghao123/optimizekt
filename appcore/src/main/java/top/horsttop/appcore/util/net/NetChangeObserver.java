package top.horsttop.appcore.util.net;


import javax.inject.Inject;


/**
 * Created by horsttop on 2018/4/18.
 */
public class NetChangeObserver {

    @Inject
    public NetChangeObserver( ) {
    }

    /**
     * 网络连接连接时调用
     */
    public void onConnect(NetWorkUtil.NetType type) {
    }

    /**
     * 当前没有网络连接
     */
    public void onDisConnect() {

    }
}
