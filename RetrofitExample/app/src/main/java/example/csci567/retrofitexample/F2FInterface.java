package example.csci567.retrofitexample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by bryandixon on 3/7/17.
 */

public interface F2FInterface {

    //    void recipeList(@Query("key") String param1, @Query("q") String query, @Query("sort") String sort, @Query("page") int page, Callback<RecipeList> cb);


    //@Headers("key:22bc1ea05b100779244d0e387f11499b")
    @GET("search")
    Call<RecipeList> listRecipes(@Query("key") String key, @Query("page") int page);
}
