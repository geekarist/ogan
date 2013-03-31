package com.github.geekarist.ogan;

import java.util.List;

import android.os.AsyncTask;

public class CaloriesLoaderAsyncTask extends
		AsyncTask<Void, Integer, List<String>> {

	private final OganCallback callback;

	public CaloriesLoaderAsyncTask(OganCallback oganCallback) {
		this.callback = oganCallback;
	}

	@Override
	protected List<String> doInBackground(Void... params) {
		return new CaloriesLoader().loadCaloriesByDayForThisWeek();
	}

	@Override
	protected void onPostExecute(List<String> result) {
		super.onPostExecute(result);
		callback.use(result);
	}

}
