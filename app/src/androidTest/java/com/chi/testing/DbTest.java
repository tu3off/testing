package com.chi.testing;

import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;

import com.chi.testing.core.bridge.DbBridge;
import com.chi.testing.db.DbManager;
import com.chi.testing.model.Test;

public class DbTest extends AndroidTestCase {

    private DbBridge dbBridge;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        dbBridge = new DbManager(getContext());
    }

    @MediumTest
    public void testInsert() {
        Test test = new Test();
        test.setName("sd");
        long id = dbBridge.insert(test);
        assertTrue(id != -1);
    }

    @MediumTest
    public void testSelect() {
        Test test = dbBridge.select();
        assertNotNull(test);
    }
}
