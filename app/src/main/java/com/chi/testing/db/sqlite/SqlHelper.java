package com.chi.testing.db.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.chi.testing.db.sqlite.entity.TestEntity;

public final class SqlHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "testing.db";
    private static final int VERSION = 1;

    public SqlHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TestEntity.CREATE_SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
