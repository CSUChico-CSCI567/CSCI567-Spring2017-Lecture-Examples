package example.csci567.retrofitexample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bryandixon on 3/7/17.
 */

public class RecipeList {
    @Expose
    public int count;

    @SerializedName("recipes")
    @Expose
    public List<Recipe> recipeItems;

    public int getCount(){
        return count;
    }

    public void setCount(int count){
        this.count=count;
    }

    public List<Recipe> getRecipeItems(){
        return recipeItems;
    }

    public void setRecipeItems(List<Recipe> recipeItems){
        this.recipeItems = recipeItems;
    }
}
