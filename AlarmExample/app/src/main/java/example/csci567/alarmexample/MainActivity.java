package example.csci567.alarmexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlarmReceiver alarmReceiver = new AlarmReceiver();
        alarmReceiver.setAlarm(this);
    }
}
