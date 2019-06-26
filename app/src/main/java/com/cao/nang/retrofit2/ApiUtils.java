package com.cao.nang.retrofit2;

/**
 * Created by Chike on 12/4/2016.
 */

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://192.168.1.226:5000";

    public static JsonPlaceHolderApi getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(JsonPlaceHolderApi.class);
    }
}
