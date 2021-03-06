package com.github.geekarist.ogan;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

public class CaloriesLoaderTest extends TestCase {
	public void testLoadCaloriesByDayForThisWeek() {
		// GIVEN
		CaloriesLoader loader = new CaloriesLoader();

		// WHEN
		List<String> calories = loader.loadCaloriesByDayForThisWeek();

		// THEN
		List<String> expectedItems = Arrays.asList("Monday: 2100",
				"Tuesday: 2150", "Wednesday: 2000", "Thursday: 0", "Friday: 0",
				"Saturday: 0", "Sunday: 0");
		Assert.assertEquals(expectedItems, calories);
	}
}
