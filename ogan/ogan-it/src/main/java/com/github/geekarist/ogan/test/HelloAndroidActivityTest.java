package com.github.geekarist.ogan.test;

import android.test.ActivityInstrumentationTestCase2;
import com.github.geekarist.ogan.*;

public class HelloAndroidActivityTest extends ActivityInstrumentationTestCase2<HelloAndroidActivity> {

    public HelloAndroidActivityTest() {
        super(HelloAndroidActivity.class); 
    }

    public void testActivity() {
        HelloAndroidActivity activity = getActivity();
        assertNotNull(activity);
    }
}

