package com.github.geekarist.ogan;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.json.JSONException;
import org.json.JSONObject;

public class CaloriesLoader {

	public List<String> loadCaloriesByDayForThisWeek() {
		String json = "{Monday: 1900, Tuesday: 2150, Wednesday: 2000, Thursday: 0, Friday: 0, Saturday: 0, Sunday: 0}";
		List<String> result = new ArrayList<String>();
		try {
			JSONObject jsonObject = new JSONObject(json);
			addDay(result, jsonObject, "Monday");
			addDay(result, jsonObject, "Tuesday");
			addDay(result, jsonObject, "Wednesday");
			addDay(result, jsonObject, "Thursday");
			addDay(result, jsonObject, "Friday");
			addDay(result, jsonObject, "Saturday");
			addDay(result, jsonObject, "Sunday");
		} catch (JSONException e) {
			return result;
		}
		return result;
	}

	private void addDay(List<String> result, final JSONObject jsonObject,
			final String day) throws JSONException {
		int calories = jsonObject.getInt(day);
		String item = String.format(Locale.ENGLISH, "%s: %d", day, calories);
		result.add(item);
	}

}
