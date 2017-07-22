package com.example.pradeep.picpose.net;

import com.example.pradeep.picpose.model.Pose;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by pradeep on 22/7/17.
 */

public interface ApiInterface {

    @GET("feeds")
    Call<Pose> getFeeds(@Query("type") String type);
}
