package de.ur.mi.android.demos.healthbestie.dashboard.SleepCalculatorFunction;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import de.ur.mi.android.demos.healthbestie.R;
import de.ur.mi.android.demos.healthbestie.dashboard.CaloriesCalculator;
import de.ur.mi.android.demos.healthbestie.dashboard.SleepCalculator;

public class SleepCalculator3rdScreen extends AppCompatActivity {

    private TextView timeResultLabel;
    private TextView nineHrsSleep, sevenHrsSleep, sixHrsSleep, fourHrsSleep;
    private RadioButton wakeUpAt, goToSleepAt;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        showResults();
    }

    private void initUI(){
        setContentView(R.layout.activity_sleep_calculator_result);
        timeResultLabel = findViewById(R.id.timeResultLabel);
        nineHrsSleep = findViewById(R.id.nine_hrs_sleep_time_result);
        sevenHrsSleep = findViewById(R.id.seven_hrs_sleep_time_result);
        sixHrsSleep = findViewById(R.id.six_hrs_sleep_time_result);
        fourHrsSleep = findViewById(R.id.four_hrs_sleep_time_result);
        wakeUpAt = findViewById(R.id.wakeUpOption);
        goToSleepAt = findViewById(R.id.sleepTimeOption);
    }

    private void showResults(){
        TimeCountHelper helper = new TimeCountHelper();
        Bundle extra = getIntent().getExtras();

        timeResultLabel.setText(extra.getString(SleepCalculator2ndScreen.RESULT_DESCRIPTION1)
                + extra.getInt(SleepCalculator2ndScreen.HOUR)
                +":" + extra.getInt(SleepCalculator2ndScreen.MINUTE)
                + "" + extra.getString(SleepCalculator2ndScreen.RESULT_DESCRIPTION2));

        if(getIntent().getStringExtra(SleepCalculator2ndScreen.WAKE_UP_OPTION_CHOSE).equals("true")) {
            helper.setWakeUpHour(extra.getInt(SleepCalculator2ndScreen.HOUR));
            helper.setWakeUpMin(extra.getInt(SleepCalculator2ndScreen.MINUTE));
            nineHrsSleep.setText(String.valueOf(helper.getHr9hrsBeforeWakeUp()) + ":" + String.valueOf(helper.getMin9hrsBeforeWakeUp()));
            sevenHrsSleep.setText(String.valueOf(helper.getHr7HrsBeforeWakeUp()) + ":" + String.valueOf(helper.getMin7hrsBeforeWakeUp()));
            sixHrsSleep.setText(String.valueOf(helper.getHr6HrsBeforeWakeUp()) + ":" + String.valueOf(helper.getMin6hrsBeforeWakeUp()));
            fourHrsSleep.setText(String.valueOf(helper.getHr4HrsBeforeWakeUp()) + ":" + String.valueOf(helper.getMin4hrsBeforeWakeUp()));
        }
        if(getIntent().getStringExtra(SleepCalculator2ndScreen.WAKE_UP_OPTION_CHOSE).equals("false")) {
            helper.setSleepHour(extra.getInt(SleepCalculator2ndScreen.HOUR));
            helper.setSleepMin(extra.getInt(SleepCalculator2ndScreen.MINUTE));
            nineHrsSleep.setText(String.valueOf(helper.getHr9hrsAfterGoToBed()) + ":" + String.valueOf(helper.getMin9hrsAfterGoToBed()));
            sevenHrsSleep.setText(String.valueOf(helper.getHr7hrsAfterGoToBed()) + ":" + String.valueOf(helper.getMin7hrsAfterGoToBed()));
            sixHrsSleep.setText(String.valueOf(helper.getHr6hrsAfterGoToBed()) + ":" + String.valueOf(helper.getMin6hrsAfterGoToBed()));
            fourHrsSleep.setText(String.valueOf(helper.getHr4hrsAfterGoToBed()) + ":" + String.valueOf(helper.getMin4hrsAfterGoToBed()));
        }
    }

}
