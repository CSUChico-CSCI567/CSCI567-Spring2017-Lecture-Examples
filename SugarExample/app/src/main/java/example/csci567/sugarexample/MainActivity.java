package example.csci567.sugarexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.orm.SugarContext;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SugarContext.init(this);
        Entity record = new Entity("Record 1");
        record.save();
        record = new Entity("Record 2");
        record.save();
        record = new Entity("Record 3");
        record.save();

        List<Entity> recordList = Entity.listAll(Entity.class);
        for(int i=0; i<recordList.size(); i++){
            Log.d(getString(R.string.sugar_example),
                    recordList.get(i).getName());
        }
        Entity.deleteAll(Entity.class);


    }
}
