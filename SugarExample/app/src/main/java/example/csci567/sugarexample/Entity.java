package example.csci567.sugarexample;

import com.orm.SugarRecord;

/**
 * Created by bryandixon on 2/23/17.
 */

public class Entity  extends SugarRecord {
    String name;

    public Entity(){
        super();
    }

    public Entity(String name){
        super();
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}