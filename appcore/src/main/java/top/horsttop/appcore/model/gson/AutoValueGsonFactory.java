package top.horsttop.appcore.model.gson;

import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

/**
 * Created by horsttop on 2018/4/13.
 */


@GsonTypeAdapterFactory
public abstract class AutoValueGsonFactory implements TypeAdapterFactory {

    // Static factory method to access the package
    // private generated implementation
//    public static TypeAdapterFactory create() {
//        return new AutoValueGson_AutoValueGsonFactory();
//    }
}

