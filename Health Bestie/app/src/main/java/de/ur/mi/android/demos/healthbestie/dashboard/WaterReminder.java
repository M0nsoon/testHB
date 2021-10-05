package de.ur.mi.android.demos.healthbestie.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import de.ur.mi.android.demos.healthbestie.R;
import de.ur.mi.android.demos.healthbestie.dashboard.Service.ReminderBroadcast;

public class WaterReminder extends AppCompatActivity implements  View.OnClickListener{

    private FloatingActionButton FloatingTooltip;
    private EditText waterLimit, remindFrequency;
    private Button confirmButton;
    private Button CancelButton;

    private static final String CHANNEL_ID = "water-notification";
    private static final String CHANNEL_NAME = "water-nofification";
    private static final String CHANNEL_DESCRIPTION = "Description here";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_reminder);
        FloatingTooltip = findViewById(R.id.waterReminder_floatingActionButton);
        waterLimit = findViewById(R.id.waterRemind_waterValue);
        confirmButton = findViewById(R.id.waterReminder_Confirm);
        CancelButton = findViewById(R.id.waterReminder_CancelButton);
        remindFrequency = findViewById(R.id.waterReminder_frequency);

        //run only on allowed versions
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESCRIPTION);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        FloatingTooltip.setTooltipText("A reminder will automatically be called for every hour");
        confirmButton.setOnClickListener(this);
        CancelButton.setOnClickListener(this);

    }


    @Override
    //setting up onClickListeners for the two buttons
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.waterReminder_Confirm:
                displayNotification();
                Toast.makeText(this,"Reminder set !",Toast.LENGTH_SHORT).show();
                break;

            case R.id.waterReminder_CancelButton:
                waterLimit.setText("");
                finish();
               break;

            default:
                break;

        }
    }

    private void displayNotification(){


        Intent intent = new Intent(this, ReminderBroadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,intent,0);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        long timeAtButtonClick = System.currentTimeMillis();
        //just for testing, change in actual product
        long sleepTime = 1000 * 10;

        long interval = Long.parseLong(remindFrequency.getText().toString());
        //repeat as user input, first start after 10 seconds
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, timeAtButtonClick + sleepTime, interval * 60000, pendingIntent);


    }
}