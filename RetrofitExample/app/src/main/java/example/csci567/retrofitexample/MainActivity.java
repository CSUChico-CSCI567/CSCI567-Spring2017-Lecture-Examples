package example.csci567.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Retrofit Example" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://food2fork.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        F2FInterface service = retrofit.create(F2FInterface.class);
        Call<RecipeList> call = service.listRecipes("22bc1ea05b100779244d0e387f11499b",1);
        call.enqueue(new Callback<RecipeList>() {
            @Override
            public void onResponse(Call<RecipeList> call, Response<RecipeList> response) {
                Log.d(TAG,response.toString());
                // Get result Repo from response.body()
                for(int i=0;i<response.body().getRecipeItems().size();i++){
                    Log.d(TAG,response.body().getRecipeItems().get(i).getTitle());
                }
            }

            @Override
            public void onFailure(Call<RecipeList> call, Throwable t) {
                Log.e(TAG,"Connection Failed: " + t.toString());
            }
        });

    }
}
