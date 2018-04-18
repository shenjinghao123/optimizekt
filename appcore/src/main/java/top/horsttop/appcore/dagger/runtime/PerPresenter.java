package top.horsttop.appcore.dagger.runtime;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by horsttop on 2018/4/18.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerPresenter {
}