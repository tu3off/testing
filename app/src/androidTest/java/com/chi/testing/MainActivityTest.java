package com.chi.testing;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.EditText;

import com.chi.testing.ui.MainActivity;

import junit.framework.Assert;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private final Class[] testClasses;
    private Activity activity;

    public MainActivityTest() {
        super(MainActivity.class);
        testClasses = new Class[]{DbTest.class};
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

    @SmallTest
    public void testSampleEditText() {
        final EditText editText = (EditText) activity.findViewById(R.id.etExample);
        final String testStringOverMaxEditTextLength = activity.getString(R.string.test_max_length_string);
        final int maxLength = activity.getResources().getInteger(R.integer.maxLength);
        editText.setTag(testStringOverMaxEditTextLength);
        Assert.assertTrue(editText.getText().length() < maxLength);
    }
}
