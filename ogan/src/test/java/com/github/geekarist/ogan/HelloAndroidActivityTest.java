package com.github.geekarist.ogan;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.mockito.Mockito;

import android.os.Bundle;
import android.widget.ArrayAdapter;

public class HelloAndroidActivityTest {

	@Test
	public void shouldLoadWeekItemsOnCreate() {
		// GIVEN
		@SuppressWarnings("unchecked")
		ArrayAdapter<String> adapterMock = Mockito.mock(ArrayAdapter.class);
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

}
