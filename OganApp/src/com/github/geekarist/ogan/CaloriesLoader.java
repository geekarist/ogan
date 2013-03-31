package com.github.geekarist.ogan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class CaloriesLoader {

	public List<String> loadCaloriesByDayForThisWeek() {
		String json = fetchCaloriesByDayForThisWeek();
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

	private String fetchCaloriesByDayForThisWeek() {
		HttpRequestBase request = new HttpGet("http://cpele.free.fr/ogan.json");
		HttpClient client = new DefaultHttpClient();
		HttpResponse response;
		try {
			response = client.execute(request);
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity);
		} catch (ClientProtocolException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void addDay(List<String> result, final JSONObject jsonObject,
			final String day) throws JSONException {
		int calories = jsonObject.getInt(day);
		String item = String.format(Locale.ENGLISH, "%s: %d", day, calories);
		result.add(item);
	}

}
