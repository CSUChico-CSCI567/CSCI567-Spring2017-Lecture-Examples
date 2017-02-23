package example.csci567.realmexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize Realm
        Realm.init(this);
        // Get a Realm instance for this thread
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Entity entity = realm.createObject(Entity.class,1); // Create managed objects directly
        entity.setName("Object1");
        entity = realm.createObject(Entity.class,2); // Create managed objects directly
        entity.setName("Object2");
        entity = realm.createObject(Entity.class,3); // Create managed objects directly
        entity.setName("Object3");
        realm.commitTransaction();

        // Build the query looking at all users:
        RealmQuery<Entity> query = realm.where(Entity.class);
        // Execute the query:
        RealmResults<Entity> result1 = query.findAll();

        for(int i=0;i<result1.size();i++){
            Log.d("TAG",result1.get(i).getName());
        }
    }
}
