package com.example.alarmmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button B1;
	EditText time;
	
	AlarmManager alarm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        time=(EditText)findViewById(R.id.editText1);
        B1=(Button)findViewById(R.id.button1);
        
        B1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int sec=Integer.parseInt(time.getText().toString());
				Intent i=new Intent(MainActivity.this,AlarmReceiver.class);
				  PendingIntent pin = PendingIntent.getBroadcast(getApplicationContext(), 1, i,PendingIntent.FLAG_UPDATE_CURRENT);
			        alarm = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
			        alarm.set(AlarmManager.RTC_WAKEUP, 1000 *sec, pin);
					
			        Toast.makeText(getApplicationContext(), "Alarm Set for "+String.valueOf(sec) + "seconds", Toast.LENGTH_LONG).show();
				}
			});

    }
}
