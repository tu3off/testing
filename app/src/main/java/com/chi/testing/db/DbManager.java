package com.chi.testing.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.chi.testing.core.bridge.DbBridge;
import com.chi.testing.db.sqlite.SqlHelper;
import com.chi.testing.db.sqlite.entity.TestEntity;
import com.chi.testing.model.Test;

public final class DbManager implements DbBridge {

    private static final String TAG = DbManager.class.getName();

    private SQLiteDatabase sqLiteDatabase;

    public DbManager(Context context) {
        final SqlHelper sqlHelper = new SqlHelper(context);
        try {
            sqLiteDatabase = sqlHelper.getWritableDatabase();
        } catch (SQLiteException exception) {
            Log.e(TAG, exception.getMessage());
            sqLiteDatabase = sqlHelper.getReadableDatabase();
        }
    }

    @Override
    public long insert(Test object) {
        return sqLiteDatabase.insert(TestEntity.TABLE_NAME, null, ObjectMapper.toTestContentValues(object));
    }

    @Override
    public Test select() {
        final Test test;
        final Cursor cursor = sqLiteDatabase.query(TestEntity.TABLE_NAME,
                null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            test = ObjectMapper.toTestModel(cursor);
            cursor.close();
        } else {
            test = null;
        }
        return test;
    }
}
