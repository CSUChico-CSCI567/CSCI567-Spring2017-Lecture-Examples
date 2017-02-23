package example.csci567.realmexample;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by bryandixon on 2/23/17.
 */



public class Entity extends RealmObject {
    @PrimaryKey
    private long id;
    private String name;
    // ... Generated getters and setters ...
    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}