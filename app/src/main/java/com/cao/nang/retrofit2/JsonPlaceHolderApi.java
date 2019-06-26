package com.cao.nang.retrofit2;

import com.cao.nang.retrofit2.model.Register;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {
    @GET("")
    Call<List<Post>> getPosts();

    @FormUrlEncoded
    @POST("users/register")
    Call<Register> insertPost(
                        @Field("name") String name,
                        @Field("email") String email,
                        @Field("password") String password,
                        @Field("password2") String password2);



    @POST("/reqadd")
    @FormUrlEncoded
    Call<Register> savePost(@Body Register register);

    @PUT("/posts/{id}")
    @FormUrlEncoded
    Call<Post> updatePost(@Path("id") long id,
                          @Field("title") String title,
                          @Field("body") String body,
                          @Field("userId") long userId);

    @DELETE("/posts/{id}")
    Call<Post> deletePost(@Path("id") long id);
}
