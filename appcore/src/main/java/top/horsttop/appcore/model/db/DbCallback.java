package top.horsttop.appcore.model.db;


import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

/**
 * Created by horsttop on 2018/4/16.
 */

final class DbCallback extends SupportSQLiteOpenHelper.Callback{
    private static final int VERSION = 1;

    DbCallback(){
        super(1);
    }

    @Override
    public void onCreate(SupportSQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SupportSQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
