package com.example.alarmmanager;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {
	
	NotificationCompat.Builder builder;
	NotificationManager manager;
	Notification notification;
	public AlarmReceiver() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onReceive(Context con, Intent arg1) {
		// TODO Auto-generated method stub
		builder = new NotificationCompat.Builder(con);
        manager = (NotificationManager)con.getSystemService(Context.NOTIFICATION_SERVICE);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("Alarm Notification");
        builder.setContentText("This is for your reminder");
        notification = builder.build();
        manager.notify(0, notification);
	}
}
