package com.packtpub.deliverydroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SelectRestaurantActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final ListView restaurants = (ListView)findViewById(R.id.restaurant);
        restaurants.setAdapter(new ArrayAdapter<String>(
        		this,
        		R.layout.menu_item,
        		getResources().getStringArray(R.array.restaurants)));
        
    }
}