package com.github.geekarist.ogan;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import de.akquinet.android.androlog.Log;

public class HelloAndroidActivity extends Activity {

    public HelloAndroidActivity(ArrayAdapter<String> adapterMock) {
		// TODO Auto-generated constructor stub
	}

	/**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after
     * previously being shut down then this Bundle contains the data it most
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initializes the logging
        Log.init();

        // Log a message (only on dev platform)
        Log.i(this, "onCreate");

        setContentView(R.layout.main);
    }

	public List<String> getListItems() {
		// TODO Auto-generated method stub
		return null;
	}

}

