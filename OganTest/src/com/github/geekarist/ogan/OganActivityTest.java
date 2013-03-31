package com.github.geekarist.ogan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

/**
 * This is a simple framework for a test of an Application. See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more
 * information on how to write and extend Application tests.
 * <p/>
 * To run this test, you can type: adb shell am instrument -w \ -e class
 * com.github.geekarist.ogan.OganActivityTest \
 * com.github.geekarist.ogan.tests/android.test.InstrumentationTestRunner
 */
public class OganActivityTest extends
		ActivityInstrumentationTestCase2<OganActivity> {

	private OganActivity activity;
	private ListView listView;

	public OganActivityTest() {
		super(OganActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		activity = getActivity();
		listView = (ListView) activity
				.findViewById(com.github.geekarist.ogan.R.id.listView1);
	}

	@UiThreadTest
	public void testLoadWeekItemsOnCreate() {
		// GIVEN
		Bundle bundle = new Bundle();

		// WHEN
		activity.onCreate(bundle);

		// THEN
		List<String> expectedItems = Arrays.asList("Monday: 1900",
				"Tuesday: 2150", "Wednesday: 2000", "Thursday: 0", "Friday: 0",
				"Saturday: 0", "Sunday: 0");
		assertEquals(7, listView.getChildCount());
		assertEquals(expectedItems, getChildren(listView));
	}

	private List<String> getChildren(ListView listView2) {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < listView2.getChildCount(); i++) {
			View childAt = listView2.getChildAt(i);
			final String text = ((TextView) childAt).getText().toString();
			result.add(text);
		}
		return result;
	}

}
