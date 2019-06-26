package com.cao.nang.retrofit2.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.cao.nang.retrofit2.BookAdapter;
import com.cao.nang.retrofit2.JsonPlaceHolderApi;
import com.cao.nang.retrofit2.Post;
import com.cao.nang.retrofit2.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    private RecyclerView rcprd;
    List <Post> l=new ArrayList<>();

    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcprd =  findViewById(R.id.rcprd);
        progress=new ProgressDialog(this);
        progress.setMessage("loading");
        progress.setCancelable(false);

        progress.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.126")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                Log.i("json",response.body().toString());
                if (!response.isSuccessful()) {

                    return;
                }else {
                    writeRecycler(response);
                }



            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });


    }
    private void writeRecycler(Response<List<Post>> response){

        List<Post> posts = response.body();
        for(Post post:posts){
            String name=post.getName();
            Log.i("item",name);

        }
        BookAdapter adapter=new BookAdapter(this,posts);
        rcprd.setLayoutManager(new LinearLayoutManager(this));
        rcprd.setAdapter(adapter);
       progress.dismiss();

    }
}
