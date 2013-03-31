package com.github.geekarist.ogan;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class OganActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final ListView listView = (ListView) findViewById(R.id.listView1);
		final OganActivity activity = this;
		new CaloriesLoaderAsyncTask(new OganCallback() {
			@Override
			public void use(List<String> result) {
				System.out.println("YO");
				listView.setAdapter(new ArrayAdapter<String>(activity,
						android.R.layout.simple_list_item_1,
						android.R.id.text1, result));
			}
		}).execute((Void) null);
	}
}
