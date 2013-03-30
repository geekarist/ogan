package com.github.geekarist.ogan.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.github.geekarist.ogan.HelloAndroidActivity;

public class HelloAndroidActivityTest extends
		ActivityInstrumentationTestCase2<HelloAndroidActivity> {

	private HelloAndroidActivity activity;
	private ListView listView;

	public HelloAndroidActivityTest() {
		super(HelloAndroidActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		activity = getActivity();
		listView = (ListView) activity
				.findViewById(com.github.geekarist.ogan.R.id.listView1);
	}

	@UiThreadTest
	public void shouldLoadWeekItemsOnCreate() {
		// GIVEN
		Bundle bundle = new Bundle();

		// WHEN
		activity.onCreate(bundle);

		// THEN
		List<String> expectedItems = Arrays.asList("Monday: 0", "Tuesday: 0",
				"Wednesday: 0", "Thursday: 0", "Friday: 0", "Saturday: 0",
				"Sunday: 0");
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
