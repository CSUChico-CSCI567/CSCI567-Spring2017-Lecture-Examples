package example.csci567.retrofitexample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import example.csci567.retrofitexample.adapters.F2FListAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Retrofit Example" ;

    public static Context context;
    private RecyclerView mRecyclerView;
    private F2FListAdapter mListAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //context = this;

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(getAdapter());

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
//                for(int i=0;i<response.body().getRecipeItems().size();i++){
//                    Log.d(TAG,response.body().getRecipeItems().get(i).getTitle());
//                }
                addItemsToList(response.body().getRecipeItems());
            }

            @Override
            public void onFailure(Call<RecipeList> call, Throwable t) {
                Log.e(TAG,"Connection Failed: " + t.toString());
            }
        });

    }

    private void addItemsToList(ArrayList<Recipe> data) {
        if (data != null) {
            if (!data.isEmpty()) {
                if(mListAdapter==null || mListAdapter.getData().size()<=0) {
                    try {
                        mListAdapter.setData(data);
                    }
                    catch (Exception e){
                        Log.e("RetroFitExample: ", e.toString());
                    }
                }
                else{
                    for(int i=0;i<data.size();i++) {
                        mListAdapter.addData(data.get(i));
                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mListAdapter.notifyDataSetChanged();
                    }
                });

            }
        }
    }

    private RecyclerView.Adapter getAdapter() {
        if (mListAdapter == null) {
            mListAdapter = new F2FListAdapter(this);
            mListAdapter.setData(new ArrayList<Recipe>());
            mListAdapter.setOnItemClickListener(
                    new F2FListAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(final Recipe item) {
                            Log.d(TAG, item.getTitle());

                        }
                    }
            );
        }
        return mListAdapter;
    }

}
