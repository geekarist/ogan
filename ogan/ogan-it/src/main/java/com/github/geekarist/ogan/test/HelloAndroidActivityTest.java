package com.github.geekarist.ogan.test;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;
import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ArrayAdapter;

import com.github.geekarist.ogan.HelloAndroidActivity;

public class HelloAndroidActivityTest extends ActivityInstrumentationTestCase2<HelloAndroidActivity> {

    public HelloAndroidActivityTest() {
        super(HelloAndroidActivity.class); 
    }

    public void shouldBeCreatedProperly() {
    	// GIVEN
        // WHEN
        HelloAndroidActivity activity = getActivity();
        // THEN
        assertNotNull(activity);
    }

	public void shouldLoadWeekItemsOnCreate() {
		// GIVEN
		ArrayAdapter<String> adapterMock = mock(ArrayAdapter.class);
		HelloAndroidActivity activity = new HelloAndroidActivity(adapterMock);
		Bundle bundle = new Bundle();
		
		// WHEN
		activity.onCreate(bundle);
		
		// THEN
		List<String> expectedItems = Arrays.asList("Monday: 0", "Tuesday: 0",
				"Wednesday: 0", "Thursday: 0", "Friday: 0", "Saturday: 0",
				"Sunday: 0");
		List<String> listItems = activity.getListItems();
		Assert.assertTrue(listItems.containsAll(expectedItems));
		Assert.assertTrue(expectedItems.containsAll(listItems));
	}

	private ArrayAdapter<String> mock(Class<?> class1) {
		// TODO Auto-generated method stub
		return null;
	}
}

