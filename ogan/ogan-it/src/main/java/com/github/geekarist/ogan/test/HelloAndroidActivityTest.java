package com.github.geekarist.ogan.test;

import android.test.ActivityInstrumentationTestCase2;

import com.github.geekarist.ogan.HelloAndroidActivity;

public class HelloAndroidActivityTest extends ActivityInstrumentationTestCase2<HelloAndroidActivity> {

    public HelloAndroidActivityTest() {
        super(HelloAndroidActivity.class); 
    }

    public void testActivity() {
        HelloAndroidActivity activity = getActivity();
        assertNotNull(activity);
    }

//	public void shouldLoadWeekItemsOnCreate() {
//		// GIVEN
//		@SuppressWarnings("unchecked")
//		ArrayAdapter<String> adapterMock = Mockito.mock(ArrayAdapter.class);
//		HelloAndroidActivity activity = new HelloAndroidActivity(adapterMock);
//		Bundle bundle = new Bundle();
//		// WHEN
//		activity.onCreate(bundle);
//		// THEN
//		List<String> expectedItems = Arrays.asList("Monday: 0", "Tuesday: 0",
//				"Wednesday: 0", "Thursday: 0", "Friday: 0", "Saturday: 0",
//				"Sunday: 0");
//		List<String> listItems = activity.getListItems();
//		Assert.assertTrue(listItems.containsAll(expectedItems));
//		Assert.assertTrue(expectedItems.containsAll(listItems));
//	}
}

