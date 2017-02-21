package example.csci567.sharedpreferenceexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    public static String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.checkbox1)
    CheckBox checkBox;

    @OnClick(R.id.checkbox1)
    public void clicked(View view) {
        SharedPreferences sharedPref = this.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(getString(R.string.checkbox_checked), checkBox.isChecked());
        editor.apply();
        Log.d(TAG,Boolean.toString(checkBox.isChecked()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        SharedPreferences sharedPref = this.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        boolean isChecked = sharedPref.getBoolean(getString(R.string.checkbox_checked), false);
        checkBox.setChecked(isChecked);
    }
}
