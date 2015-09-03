package com.chi.testing.db;

import android.content.ContentValues;
import android.database.Cursor;

import com.chi.testing.db.sqlite.entity.TestEntity;
import com.chi.testing.model.Test;

public final class Mapping {

    static ContentValues contentValues;

    static {
        contentValues = new ContentValues();
    }

    static ContentValues toTestContentValues(Test test) {
        contentValues.clear();
        contentValues.put(TestEntity.NAME, test.getName());
        return contentValues;
    }

    static Test toTestModel(Cursor cursor) {
        final String name = cursor.getString(cursor.getColumnIndex(TestEntity.NAME));
        final Test test = new Test();
        test.setName(name);
        return test;
    }
}
