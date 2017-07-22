package com.example.pradeep.picpose.net;

import okhttp3.HttpUrl;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pradeep on 22/7/17.
 */

public class ApiClient {

    private static final String BASE_URL = "";
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
       if(retrofit == null){
           retrofit = new Retrofit.Builder()
                   .baseUrl(BASE_URL)
                   .addConverterFactory(GsonConverterFactory.create())
                   .build();
       }
        return retrofit;
    }
}
