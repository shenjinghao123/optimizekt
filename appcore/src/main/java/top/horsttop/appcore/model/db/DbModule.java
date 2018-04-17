package top.horsttop.appcore.model.db;

import android.app.Application;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.framework.FrameworkSQLiteOpenHelperFactory;

import com.squareup.sqlbrite3.BriteDatabase;
import com.squareup.sqlbrite3.SqlBrite;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by horsttop on 2018/4/16.
 */

@Module
public final class DbModule {
    @Provides
    @Singleton
    SqlBrite provideSqlBrite() {
        return new SqlBrite.Builder()
                .logger(new SqlBrite.Logger() {
                    @Override public void log(String message) {
                        Timber.tag("Database").v(message);
                    }
                })
                .build();
    }

    @Provides @Singleton
    BriteDatabase provideDatabase(SqlBrite sqlBrite, Application application) {
        SupportSQLiteOpenHelper.Configuration configuration = SupportSQLiteOpenHelper.Configuration.builder(application)
                .name("todo.db")
                .callback(new DbCallback())
                .build();
        SupportSQLiteOpenHelper.Factory factory = new FrameworkSQLiteOpenHelperFactory();
        SupportSQLiteOpenHelper helper = factory.create(configuration);
        BriteDatabase db = sqlBrite.wrapDatabaseHelper(helper, Schedulers.io());
        db.setLoggingEnabled(true);
        return db;
    }
}