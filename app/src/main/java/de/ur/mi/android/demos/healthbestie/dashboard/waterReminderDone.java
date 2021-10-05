package de.ur.mi.android.demos.healthbestie.dashboard;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.ur.mi.android.demos.healthbestie.R;
import de.ur.mi.android.demos.healthbestie.dashboard.Service.ReminderBroadcast;

public class waterReminderDone extends AppCompatActivity implements View.OnClickListener {

    TextView display;
    Button reset, pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_reminder_done);

        Intent intent = getIntent();
        display = findViewById(R.id.remindDone_text);
        reset = findViewById(R.id.remindDone_resetButton);



        String varName = intent.getStringExtra("userInput");

        display.setText("You will be reminded for every " + varName+ " minutes");

        reset.setOnClickListener(this);


    }




    @Override
    public void onClick(View view) {
        switch (view.getId()) {


            case R.id.remindDone_resetButton:
                resetAlarm();
        }
    }

    private void resetAlarm() {
        Intent intent = new Intent(this, ReminderBroadcast.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,intent,0);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.cancel(pendingIntent);

        Intent previousScreen = new Intent(getApplicationContext(), WaterReminder.class);
        setResult(1000,previousScreen);
        finish();


    }

}