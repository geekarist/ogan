package com.github.geekarist.ogan;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

public class HelloAndroidActivity extends Activity {

    private static String TAG = "ogan";

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
		Log.i(TAG, "onCreate");
        setContentView(R.layout.main);
    }

	public List<String> getListItems() {
		// TODO Auto-generated method stub
		return null;
	}

}

