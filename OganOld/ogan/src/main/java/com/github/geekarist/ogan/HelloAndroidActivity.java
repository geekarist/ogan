package com.github.geekarist.ogan;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import de.akquinet.android.androlog.Log;

public class HelloAndroidActivity extends Activity {

	/**
	 * Called when the activity is first created.
	 * 
	 * @param savedInstanceState
	 *            If the activity is being re-initialized after previously being
	 *            shut down then this Bundle contains the data it most recently
	 *            supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it
	 *            is null.</b>
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Initializes the logging
		Log.init();

		// Log a message (only on dev platform)
		Log.i(this, "onCreate");

		setContentView(R.layout.main);
		ListView listView = (ListView) findViewById(R.id.listView1);
		List<String> items = loadItems();
		listView.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, items));
	}

	private List<String> loadItems() {
		String json = "{Monday: 0, Tuesday: 0, Wednesday: 0, Thursday: 0, Friday: 0, Saturday: 0, Sunday: 0}";
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
