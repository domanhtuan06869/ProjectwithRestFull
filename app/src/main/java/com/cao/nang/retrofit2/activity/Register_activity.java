package com.cao.nang.retrofit2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.cao.nang.retrofit2.ApiUtils;
import com.cao.nang.retrofit2.JsonPlaceHolderApi;
import com.cao.nang.retrofit2.R;
import com.cao.nang.retrofit2.model.Register;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register_activity extends AppCompatActivity {
 JsonPlaceHolderApi jsonPlaceHolderApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        sendPost();
    }

    public void sendPost() {

        // RxJava
        /*mAPIService.savePost(title, body, 1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Post>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Post post) {
                        showResponse(post.toString());
                    }
                });

*/
        jsonPlaceHolderApi= ApiUtils.getAPIService();

       jsonPlaceHolderApi.insertPost("dmt","dmanh@gmail.com","manhtuan","manhtuan").enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {

                if(response.isSuccessful()) {

                    Log.i("loi", "post submitted to API." +response.body().toString());
                }

            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {


                Log.e("ddd", "Unable to submit post to API.");
            }
        });
    }

}
